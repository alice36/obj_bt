package pl.javastart.springdata.model;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

//    @OneToOne(fetch = FetchType.LAZY, mappedBy = "ticket", cascade = CascadeType.ALL)
    @OneToOne(cascade = CascadeType.ALL)
    private Voucher voucher;

    private String person;
    private String login;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate travelDate;

    private String fromPlace;
    private String toPlace;

    @Enumerated(EnumType.STRING)
    private Client clientName;
    private String commentaryTr;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Voucher getVoucher() {
        return voucher;
    }

    public void setVoucher(Voucher voucher) {
        this.voucher = voucher;
    }

    public String getPerson() {
        return person;
    }

    public void setPerson(String person) {
        this.person = person;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public LocalDate getTravelDate() {
        return travelDate;
    }

    public void setTravelDate(LocalDate travelDate) {
        this.travelDate = travelDate;
    }

    public String getCommentaryTr() {
        return commentaryTr;
    }

    public void setCommentaryTr(String commentaryTr) {
        this.commentaryTr = commentaryTr;
    }

    public String getFromPlace() {
        return fromPlace;
    }

    public void setFromPlace(String fromPlace) {
        this.fromPlace = fromPlace;
    }

    public String getToPlace() {
        return toPlace;
    }

    public void setToPlace(String toPlace) {
        this.toPlace = toPlace;
    }

    public Client getClientName() {
        return clientName;
    }

    public void setClientName(Client clientName) {
        this.clientName = clientName;
    }
}
