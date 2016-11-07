package entities;
// Generated Nov 2, 2016 10:23:53 PM by Hibernate Tools 4.3.1.Final

import java.math.BigDecimal;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * CreditCard generated by hbm2java
 */
@Entity
@Table(name = "credit_card", catalog = "booking_project")
public class CreditCard implements java.io.Serializable {

	private int id;
	private String cardNumber;
	private BigDecimal balance;

	public CreditCard() {
	}

	public CreditCard(int id) {
		this.id = id;
	}

	public CreditCard(int id, String cardNumber, BigDecimal balance) {
		this.id = id;
		this.cardNumber = cardNumber;
		this.balance = balance;
	}

	@Id

	@Column(name = "id", unique = true, nullable = false)
	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Column(name = "card_number", length = 50)
	public String getCardNumber() {
		return this.cardNumber;
	}

	public void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	@Column(name = "balance", scale = 4)
	public BigDecimal getBalance() {
		return this.balance;
	}

	public void setBalance(BigDecimal balance) {
		this.balance = balance;
	}

}
