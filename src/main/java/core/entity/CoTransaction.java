package core.entity;


import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
@Table(name = "CO_TRANSACTION")
public class CoTransaction extends BaseEntity{


    protected long id;
    protected String sender;
    protected String receiver;
    protected long amount;

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "TRANSACTION_SEQ")
    @SequenceGenerator(name = "TRANSACTION_SEQ", sequenceName = "TRANSACTION_SEQ")
    @JsonProperty
    @Column(name = "ID")
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

    @JsonProperty
    @Column(name = "SENDER")
    public String getSender() {
        return sender;
    }
    public void setSender(String sender) {
        this.sender = sender;
    }

    @JsonProperty
    @Column(name = "RECIVER")
    public String getReceiver() {
        return receiver;
    }
    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }

    @JsonProperty
    @Column(name = "AMOUNT")
    public long getAmount() {
        return amount;
    }
    public void setAmount(long amount) {
        this.amount = amount;
    }









}
