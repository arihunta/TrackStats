package arihunta.trackstats

import arihunta.trackstats.model.Track
import arihunta.trackstats.model.gpxFromTracks
import arihunta.trackstats.model.gpxFromFile
import arihunta.trackstats.model.toTracks
import arihunta.trackstats.model.writeToFile
import arihunta.trackstats.model.kmlFromTracks
import java.io.File
import java.nio.file.Path
import java.nio.file.Paths
import jakarta.xml.bind.JAXBContext
import jakarta.xml.bind.JAXBElement

public class Controller {

	val loadedTracks: MutableList<Track> = mutableListOf()

	fun loadGpxFile(file: Path) = if (file != null) loadedTracks.addAll(gpxFromFile(file).toTracks()) else {}

	fun createFlyBy(tracks: List<Track>, file: Path) {

		val startTime = tracks.map { it.time }.maxOrNull()

		if (startTime != null) {
			kmlFromTracks(tracks.map { it.toTime(startTime).copy(name = "${it.name}: ${it.date}") }).writeToFile(file)
		}

	}

}

fun main(args: Array<String>) {

	val conti = Controller();
//	conti.loadGpxFile(Paths.get("C:\\Users\\arihu\\workspace\\TrackStats\\src\\main\\resources\\gpx_example_1.gpx"))
	conti.loadGpxFile(Paths.get("C:\\Users\\arihu\\Downloads\\Don_Locke_Memorial_Race_2023.gpx"))
	conti.loadGpxFile(Paths.get("C:\\Users\\arihu\\Downloads\\Don_Lock_Memorial_Run_2023_15km.gpx"))
	conti.createFlyBy(conti.loadedTracks, Paths.get("C:\\Users\\arihu\\OneDrive\\Desktop\\demoby.kml"))

}
