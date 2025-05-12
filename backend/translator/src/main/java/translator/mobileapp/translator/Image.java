package translator.mobileapp.translator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
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

    @ManyToOne
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

    public String getFilePath() {
        return filePath;
    }

    public void setFilePath(String filePath) {
        this.filePath = filePath;
    }

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
