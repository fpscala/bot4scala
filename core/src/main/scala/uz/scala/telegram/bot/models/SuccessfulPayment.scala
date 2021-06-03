package uz.scala.telegram.bot.models

/**
 * SuccessfulPayment
 *
 * This object contains basic information about a successful payment.
 *
 * @param currency                   String	Three-letter ISO 4217 currency code
 * @param total_amount               Integer	Total price in the smallest units of the currency (integer, not float/double). For example, for a price of US$ 1.45 pass amount = 145. See the exp parameter in currencies.json, it shows the number of digits past the decimal point for each currency (2 for the majority of currencies).
 * @param invoice_payload            String	Bot specified invoice payload
 * @param shipping_option_id         String	Optional. Identifier of the shipping option chosen by the user
 * @param order_info                 OrderInfo	Optional. Order info provided by the user
 * @param telegram_payment_charge_id String	Telegram payment identifier
 * @param provider_payment_charge_id String	Provider payment identifier
 * */
case class SuccessfulPayment(
  currency: String,
  total_amount: String,
  invoice_payload: String,
  shipping_option_id: Option[String] = None,
  order_info: Option[OrderInfo] = None,
  telegram_payment_charge_id: Option[String] = None,
  provider_payment_charge_id: Option[String] = None
)
