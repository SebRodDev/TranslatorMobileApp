package translator.mobileapp.translator;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "image")
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "uploadDate")
    private String uploadDate;

    @Column(name = "filePath")
    private String filePath;

    @Column(name = "fileName")
    private String fileName;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private User user;
    // empty constructor just in case
    public Image() {}

    public Image(String uploadDate, String filePath, String fileName) {
        this.uploadDate = uploadDate;
        this.filePath = filePath;
        this.fileName = fileName;
    }

    // getters and setters for all of the fields
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUploadDate() {
        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {
        this.uploadDate = uploadDate;
    }
}
