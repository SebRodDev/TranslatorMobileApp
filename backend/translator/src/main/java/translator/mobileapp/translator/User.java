package translator.mobileapp.translator;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class User {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "username", nullable = false)
    private String username;

    @Column(name = "password", nullable = false)
    private String password;

    // this means one user to many images mapped by a value of user 
    // cascade informs which the sides to perform certain operations so by saying ALL
    // we are informing to consider all operations on the image and user side
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "user")
    private List<Image> images;

    // empty constructor -- unsure of the cases currently
    public User() {}

    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }

    // getters and setters for all of the fields

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Image> getImages() {
        return images;
    }

    public void setImages(List<Image> images) {
        this.images = images;
    }
}
