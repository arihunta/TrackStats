package arihunta.trackstats.model

import com.topografix.gpx._1._1.GpxType
import com.topografix.gpx._1._1.TrkType
import com.topografix.gpx._1._1.TrksegType
import com.topografix.gpx._1._1.WptType
import java.math.BigDecimal
import com.topografix.gpx._1._1.ObjectFactory
import java.util.GregorianCalendar
import java.util.Date
import javax.xml.datatype.DatatypeFactory
import java.io.File
import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.Marshaller
import jakarta.xml.bind.JAXBElement
import java.nio.file.Path

fun GpxType.toTracks(): List<Track> =
		getTrk().map {
			Track(
					it.name,
					it.getTrkseg().flatMap { it.getTrkpt() }
							.map { TrackPoint(it.time.toGregorianCalendar().time.time, it.lat.toDouble(), it.lon.toDouble()) }
			)
		}

fun GpxType.writeToFile(file : Path) {
	val jaxbMarshaller = JAXBContext.newInstance("com.topografix.gpx._1._1").createMarshaller()
	jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	jaxbMarshaller.marshal(ObjectFactory().createGpx(this), file.toFile());
}

fun gpxFromTracks(tracks : List<Track>) : GpxType {

	val factory = ObjectFactory()
	val gpx = factory.createGpxType()

	// add the tracks
	gpx.trk.addAll(tracks.map {

		val trk = TrkType()
		trk.name = it.name
		val segment = TrksegType()

		// each track has one segment, with all of its waypoints
		segment.trkpt.addAll(it.points.map {

			val wpt = WptType()
			wpt.lat = BigDecimal(it.lat_deg)
			wpt.lon = BigDecimal(it.lon_deg)

			val calendar = GregorianCalendar()
			calendar.setTime(Date(it.time))
			wpt.time = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar)

			// TODO support for extensions

			return@map wpt

		})
		trk.trkseg.add(segment)

		return@map trk

	})

	return gpx

}

fun gpxFromFile(file: Path): GpxType {

	val jobj = JAXBContext.newInstance("com.topografix.gpx._1._1").createUnmarshaller().unmarshal(file.toFile())

	if (jobj is JAXBElement<*>) {
		val gpx = jobj.value
		if (gpx is com.topografix.gpx._1._1.GpxType) {
			return gpx
		}
	}
	return ObjectFactory().createGpxType()

}
