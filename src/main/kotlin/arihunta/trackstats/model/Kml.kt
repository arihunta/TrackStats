package arihunta.trackstats.model

import com.google.kml.ext._2.TrackType
import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.Marshaller
import net.opengis.kml._2.KmlType
import java.awt.Color
import java.awt.Color.getHSBColor
import java.nio.file.Path
import java.time.Instant
import com.google.kml.ext._2.ObjectFactory as KmlExtFactory
import net.opengis.kml._2.ObjectFactory as KmlObjectFactory

fun KmlType.writeToFile(file : Path) {
	val jaxbMarshaller = JAXBContext.newInstance(KmlType::class.java, TrackType::class.java).createMarshaller()
	jaxbMarshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
	jaxbMarshaller.marshal(KmlObjectFactory().createKml(this), file.toFile());
}

val athletesTracks = mapOf(
	"Don Locke Memorial Race 2023: 2023-10-22T06:11:06" to "16609273",
	"Don Lock Memorial Run 2023 15km: 2023-10-22T06:11:19" to "1746590"
)

val athletesIcons = mapOf(
	"16609273" to "https://dgalywyr863hv.cloudfront.net/pictures/athletes/16609273/5118231/3/medium.jpg",
	"1746590" to "https://dgalywyr863hv.cloudfront.net/pictures/athletes/1746590/500895/1/medium.jpg"
)

fun kmlFromTracks(tracks : List<Track>) : KmlType {

	val kmlFactory = KmlObjectFactory()
	val kmlExtFactory = KmlExtFactory()

	val athletes = tracks.map { athletesTracks[it.name] }.filterNotNull()
	val colours = generateColours(athletes.size)

	val styles = athletes.zip(0..athletes.size).map { (ath, i) ->
		val style = kmlFactory.createStyleType()
		style.lineStyle = kmlFactory.createLineStyleType()
		style.lineStyle.width = 5.0
		style.lineStyle.color = byteArrayOf(colours.get(i).alpha.toByte(), colours.get(i).blue.toByte(), colours.get(i).green.toByte(), colours.get(i).red.toByte())
		style.id = "style_${ath}"
		style.iconStyle = kmlFactory.createIconStyleType()
		style.iconStyle.icon = kmlFactory.createBasicLinkType()
		style.iconStyle.icon.href = athletesIcons[ath]
		kmlFactory.createStyle(style)
	}

	val kmlTracks = tracks.map { track ->
		val kmlTrack = kmlExtFactory.createTrackType()
		track.points.forEach { point ->
			kmlTrack.`when`.add(Instant.ofEpochMilli(point.time).toString())
			kmlTrack.coord.add("${point.lon_deg} ${point.lat_deg} 0")
		}

		val placemark = kmlFactory.createPlacemarkType()
		placemark.styleUrl = "#style_${athletesTracks[track.name]}"
		placemark.abstractGeometryGroup = kmlExtFactory.createTrack(kmlTrack)
		kmlFactory.createPlacemark(placemark)
	}

	val kml = kmlFactory.createKmlType()
	val document = kmlFactory.createDocumentType()
	document.name = "FlyBy"
	document.abstractStyleSelectorGroup.addAll(styles)
	document.abstractFeatureGroup.addAll(kmlTracks)
	kml.abstractFeatureGroup = kmlFactory.createDocument(document)
	return kml

}

fun generateColours(numColours: Int) : List<Color> {
	val colours: MutableList<Color> = mutableListOf()
	for(i in 0..360 step (360 / numColours)) {
		colours.add(getHSBColor((i.toFloat() / 360f), 1.0f, 0.5f))
	}
	return colours;
}
