package arihunta.trackstats.model

import java.time.Instant
import java.time.ZoneId
import java.time.format.DateTimeFormatter

data class Track(val name: String, val points: List<TrackPoint>) {

	private val dateFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

	val time = if (points.size == 0) {0} else {points.get(0).time}

	val date = Instant.ofEpochMilli(time).atZone(ZoneId.systemDefault()).toLocalDateTime();
	
	fun toTime(time : Long) = this.copy(points = this.points.map { it.copy(time = it.time + time - this.points.get(0).time) })

	override fun toString() = "${date.format(dateFormat)}:    $name"

}

data class TrackPoint(val time: Long, val lat_deg: Double, val lon_deg: Double)
