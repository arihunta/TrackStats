package arihunta.trackstats.model

import com.google.earth.kml._2.KmlType
import com.google.earth.kml._2.ObjectFactory
import com.topografix.gpx._1._1.TrkType
import java.awt.Color.getHSBColor
import java.awt.Color
import java.nio.file.Path
import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.Marshaller

fun KmlType.writeToFile(file : Path) {
	val jaxbMarshaller = JAXBContext.newInstance("com.google.earth.kml._2").createMarshaller()
	jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	jaxbMarshaller.marshal(ObjectFactory().createKml(this), file.toFile());
}

fun kmlFromTracks(tracks : List<Track>) : KmlType {

	val colours = generateColours(tracks.size)

	val factory = ObjectFactory()
	val kml = factory.createKmlType()
	val document = factory.createDocumentType()
	document.name = "docdoc"

//	for (i in 0..colours.size - 1) {
//		val style = factory.createStyleType()
//		style.lineStyle = factory.createLineStyleType()
//		style.lineStyle.color = byteArrayOf(colours.get(i).alpha.toByte(), colours.get(i).blue.toByte(), colours.get(i).green.toByte(), colours.get(i).red.toByte())
//	}
//
//	tracks.map {
//		val placemark = factory.createPlacemarkType()
//		placemark.name = it.name
//	}
//
//	// add the tracks
//	kml.trk.addAll(tracks.map {
//
//		val trk = TrkType()
//		trk.name = it.name
//		val segment = TrksegType()
//
//		// each track has one segment, with all of its waypoints
//		segment.trkpt.addAll(it.points.map {
//
//			val wpt = WptType()
//			wpt.lat = BigDecimal(it.lat_deg)
//			wpt.lon = BigDecimal(it.lon_deg)
//
//			val calendar = GregorianCalendar()
//			calendar.setTime(Date(it.time))
//			wpt.time = DatatypeFactory.newInstance().newXMLGregorianCalendar(calendar)
//
//			// TODO support for extensions
//
//			return@map wpt
//
//		})
//		trk.trkseg.add(segment)
//
//		return@map trk
//
//	})

	kml.feature = factory.createFeature(document)
	kml.feature.value = document
	return kml

}

fun generateColours(numColours: Int) : List<Color> {

	val colours: MutableList<Color> = mutableListOf()

	for(i in 0..360 step (360 / numColours)) {
		colours.add(getHSBColor(i.toFloat(), (90 + 0 * 10).toFloat(), (50 + 0 * 10).toFloat()))
	}

	return colours;

}
