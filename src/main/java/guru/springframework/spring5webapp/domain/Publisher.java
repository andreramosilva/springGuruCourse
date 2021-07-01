package guru.springframework.spring5webapp.domain;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Publisher {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    private String name;
    private String addressLine1;
    private String zipCode;
    private String addressState;
    private String city;
    private String addressLine2;

    @OneToMany
    @JoinColumn(name = "publisher_id")
    private Set<Book> books = new HashSet<>();


    public Publisher() {
    }

    public Publisher(String name, String addressLine1, String zipCode, String addressState, String city, String addressLine2) {
        this.name = name;
        this.addressLine1 = addressLine1;
        this.zipCode = zipCode;
        this.addressState = addressState;
        this.city = city;
        this.addressLine2 = addressLine2;
    }

    public void setBooks(Set<Book> books) {
        this.books = books;
    }

    public Set<Book> getBooks() {
        return books;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddressLine1() {
        return addressLine1;
    }

    public void setAddressLine1(String addressLine1) {
        this.addressLine1 = addressLine1;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getAddressState() {
        return addressState;
    }

    public void setAddressState(String addressState) {
        this.addressState = addressState;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getAddressLine2() {
        return addressLine2;
    }

    public void setAddressLine2(String addressLine2) {
        this.addressLine2 = addressLine2;
    }

    public String toString() {
        return "Publisher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", addressLine1='" + addressLine1 + '\'' +
                ", zipCode='" + zipCode + '\'' +
                ", addressState='" + addressState + '\'' +
                ", city='" + city + '\'' +
                ", addressLine2='" + addressLine2 + '\'' +
                '}';
    }

    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Publisher)) return false;

        Publisher publisher = (Publisher) o;

        if (id != null ? !id.equals(publisher.id) : publisher.id != null) return false;
        if (name != null ? !name.equals(publisher.name) : publisher.name != null) return false;
        if (addressLine1 != null ? !addressLine1.equals(publisher.addressLine1) : publisher.addressLine1 != null)
            return false;
        if (zipCode != null ? !zipCode.equals(publisher.zipCode) : publisher.zipCode != null) return false;
        if (addressState != null ? !addressState.equals(publisher.addressState) : publisher.addressState != null)
            return false;
        if (city != null ? !city.equals(publisher.city) : publisher.city != null) return false;
        return addressLine2 != null ? addressLine2.equals(publisher.addressLine2) : publisher.addressLine2 == null;
    }

    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (addressLine1 != null ? addressLine1.hashCode() : 0);
        result = 31 * result + (zipCode != null ? zipCode.hashCode() : 0);
        result = 31 * result + (addressState != null ? addressState.hashCode() : 0);
        result = 31 * result + (city != null ? city.hashCode() : 0);
        result = 31 * result + (addressLine2 != null ? addressLine2.hashCode() : 0);
        return result;
    }
}
