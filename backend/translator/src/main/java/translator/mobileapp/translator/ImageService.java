package translator.mobileapp.translator;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ImageService {
    private ImageRepository imageRepository;
    private UserRepository userRepository;

    @Autowired
    public ImageService(ImageRepository imageRepository, UserRepository userRepository) {
        this.imageRepository = imageRepository;
        this.userRepository = userRepository;
    }

    // create an image -- we need the user id in order to create it
    public Image createImage(Long userId, Image newImage) {
        if ((newImage.getFileName() == null) || (newImage.getFilePath() == null) || (newImage.getUploadDate() == null)) {
            // do not create an image if the image that is provided does not have the necessary fields filled in
            return null;
        }

        // calling the user repository to find a user returns an optional object
        Optional<User> foundUserOptional = userRepository.findById(userId);
        
        // obtaining the user that was found when we called the userRepository
        User foundUser = foundUserOptional.get();
        // creating the link between the user and the 
        newImage.setUser(foundUser);
        return imageRepository.save(newImage);
    }

    public boolean deleteImage(Long userId, Long imageId) {
        // ensuring that the user exists as well as the image exists before attempting to delete the image
        if ((userRepository.existsById(userId)) && (imageRepository.existsById(imageId))) {
            imageRepository.deleteById(imageId);
            return true;
        } else {
            return false;
        }
    }

    // add more methods when necessary
}
