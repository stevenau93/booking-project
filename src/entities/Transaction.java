package entities;
// Generated Nov 2, 2016 10:23:53 PM by Hibernate Tools 4.3.1.Final

import java.util.Date;
import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Transaction generated by hbm2java
 */
@Entity
@Table(name = "transaction", catalog = "booking_project")
public class Transaction implements java.io.Serializable {

	private TransactionId id;
	private String creditCardType;
	private String holderName;
	private String cardNumber;
	private String cardIdentificationNumber;
	private Date expirationDate;

	public Transaction() {
	}

	public Transaction(TransactionId id) {
		this.id = id;
	}

	public Transaction(TransactionId id, String creditCardType, String holderName, String cardNumber,
			String cardIdentificationNumber, Date expirationDate) {
		this.id = id;
		this.creditCardType = creditCardType;
		this.holderName = holderName;
		this.cardNumber = cardNumber;
		this.cardIdentificationNumber = cardIdentificationNumber;
		this.expirationDate = expirationDate;
	}

	@EmbeddedId

	@AttributeOverrides({
			@AttributeOverride(name = "paymentId", column = @Column(name = "payment_id", nullable = false)),
			@AttributeOverride(name = "bookingId", column = @Column(name = "booking_id", nullable = false, length = 45)) })
	public TransactionId getId() {
		return this.id;
	}

	public void setId(TransactionId id) {
		this.id = id;
	}

	@Column(name = "credit_card_type", length = 50)
	public String getCreditCardType() {
		return this.creditCardType;
	}

	public void setCreditCardType(String creditCardType) {
		this.creditCardType = creditCardType;
	}

	@Column(name = "holder_name", length = 50)
	public String getHolderName() {
		return this.holderName;
	}

	public void setHolderName(String holderName) {
		this.holderName = holderName;
	}

	@Column(name = "card_number", length = 100)
	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "card_identification_number", length = 100)
	public String getCardIdentificationNumber() {
		return this.cardIdentificationNumber;
	}

	public void setCardIdentificationNumber(String cardIdentificationNumber) {
		this.cardIdentificationNumber = cardIdentificationNumber;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "expiration_date", length = 19)
	public Date getExpirationDate() {
		return this.expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}

}
