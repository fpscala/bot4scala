package uz.scala.telegram.bot.models

/**
 * Venue
 *
 * This object represents a venue.
 *
 * @param location          Location	Venue location. Can't be a live location
 * @param title             String	Name of the venue
 * @param address           String	Address of the venue
 * @param foursquare_id     String	Optional. Foursquare identifier of the venue
 * @param foursquare_type   String	Optional. Foursquare type of the venue. (For example, “arts_entertainment/default”, “arts_entertainment/aquarium” or “food/icecream”.)
 * @param google_place_id   String	Optional. Google Places identifier of the venue
 * @param google_place_type String	Optional. Google Places type of the venue. (See supported types.)
 * */
case class Venue(
  location: Location,
  title: String,
  address: String,
  foursquare_id: Option[String] = None,
  foursquare_type: Option[String] = None,
  google_place_id: Option[String] = None,
  google_place_type: Option[String] = None
)