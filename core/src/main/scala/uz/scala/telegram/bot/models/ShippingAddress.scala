package uz.scala.telegram.bot.models

/**
 * ShippingAddress
 *
 * This object represents a shipping address.
 *
 * @param country_code String	ISO 3166-1 alpha-2 country code
 * @param state        String	State, if applicable
 * @param city         String	City
 * @param street_line1 String	First line for the address
 * @param street_line2 String	Second line for the address
 * @param post_code    String	Address post code
 * */

case class ShippingAddress(
  country_code: String,
  state: String,
  city : String,
  street_line1: String,
  street_line2: String,
  post_code: String
)
