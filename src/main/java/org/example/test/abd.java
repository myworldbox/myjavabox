import io.qameta.allure.Allure;
import io.qameta.allure.model.*;
import org.example.global.allure;
import org.example.global.variable;

import java.awt.*;
import java.io.IOException;
import java.util.*;
import java.util.List;

public class abd extends variable {

    public static void main(String[] args) throws IOException, AWTException {

        allure.init();

        // Create an attachment (optional)
        // Attachment attachment = new Attachment()
        //        .setName("Screenshot")
        //        .setType("image/png")
        //        .setSource("https://myworldbox.github.io/resource/image/logo/VL_0.png");

        // attachments.add(attachment);

        allure.create_step("step_1", Status.FAILED, attachments);
        allure.create_step("step_2", Status.FAILED, attachments);
        allure.create_step("step_3", Status.FAILED, attachments);

        // Set the child steps list as the steps of the main test result


        // start_test_case();

        // Start the sub-step

        // Add the attachment to Allure
        // byte[] attachmentContent = Files.readAllBytes(Paths.get(attachment.getSource()));
        //Allure.addAttachment(attachment.getName(), attachment.getType(), ".png", Arrays.toString(attachmentContent));

        allure.end();
    }
}