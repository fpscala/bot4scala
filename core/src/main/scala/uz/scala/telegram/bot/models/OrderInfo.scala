package uz.scala.telegram.bot.models

/**
 * OrderInfo
 *
 * This object represents information about an order.
 *
 * @param name	String	Optional. User name
 * @param phone_number	String	Optional. User's phone number
 * @param email	String	Optional. User email
 * @param shipping_address	ShippingAddress	Optional. User shipping address
 * */

case class OrderInfo(
  name: Option[String] = None,
  phone_number: Option[String] = None,
  email: Option[String] = None,
  shipping_address: Option[ShippingAddress] = None
)
