package com.thebtnco.web.controller;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;
import com.thebtnco.persistence.domain.Customer;
import com.thebtnco.persistence.domain.Movie;
import com.thebtnco.persistence.service.MovieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import sun.misc.BASE64Decoder;
import javax.servlet.http.HttpServletResponse;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.net.URLConnection;
import java.nio.charset.Charset;

@RestController
@RequestMapping("/api")
public class RESTApiController {

//    @RequestMapping(value = "/getString", method = RequestMethod.GET, produces = "application/json")
//    private static final String DEST = "D:/Test PDFs/";
    private static final String DEST = "/home/ubuntu/pdfs/";
    private String fileLocation;

    @SuppressWarnings("SpringAutowiredFieldsWarningInspection")
    @Autowired
    private MovieService movieService;

    @RequestMapping(method = RequestMethod.GET, value = "/view/allMovies")
    public ResponseEntity findAllMovies() {
        return new ResponseEntity<>(movieService.getAll(), HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/edit/allMovies")
    public String deleteMovie(@RequestBody Movie movie, RedirectAttributes redirectAttributes) {

        Long id = movie.getId();
        movieService.save(movie);

        // Rerdirect after post to avoid duplicate form submission
        redirectAttributes.addAttribute("id", id);

        return "redirect:plex";
    }

    @RequestMapping(method = RequestMethod.POST, value = "/edit/movie")
    public void editMovie(@RequestBody Movie movie) {
        movieService.editAndSave(movie);
    }

    @ResponseBody
    @RequestMapping(method = RequestMethod.POST, value = "/createPdf")
    public void createPDF(@RequestBody Customer customer) throws Exception {
        fileLocation = DEST + customer.getFirstName() + customer.getLastName();
        Document document = new Document();
        try {

            PdfWriter.getInstance(document, new FileOutputStream(new File(fileLocation + ".pdf")));

            // Open
            document.open();

            Font f12 = new Font();
            f12.setSize(12);
            Font f10 = new Font();
            f10.setSize(12);
//            f10.setStyle(Font.BOLD);

            Paragraph header = new Paragraph("Defendant form", f12);
            header.setAlignment(Element.ALIGN_CENTER);
            Paragraph deviceSelected = new Paragraph("Device Selected: " + customer.getDeviceSelected(), f10);
            Paragraph firstName = new Paragraph("First name: " + customer.getFirstName(), f10);
            Paragraph lastName = new Paragraph("Last name: " + customer.getLastName(), f10);
            Paragraph dateOfBirth = new Paragraph("Date of Birth: " + customer.getDateOfBirth(), f10);
            Paragraph sex = new Paragraph("Sex: " + customer.getSex(), f10);
            Paragraph height = new Paragraph("Height: " + customer.getHeight(), f10);
            Paragraph phoneNum = new Paragraph("Phone number: " + customer.getPhoneNum(), f10);
            Paragraph email = new Paragraph("email: " + customer.getEmail(), f10);
            Paragraph dLicenseNum = new Paragraph("Drivers License #: " + customer.getdLicenseNum(), f10);
            Paragraph sSecurityNum = new Paragraph("SSN #: " + customer.getsSecurityNum(), f10);
            Paragraph addLine1 = new Paragraph("Address Line 1: " + customer.getAddLine1(), f10);
            Paragraph addLine2 = new Paragraph("Address Line 2: " + customer.getAddLine2(), f10);
            Paragraph city = new Paragraph("City: " + customer.getCity(), f10);
            Paragraph state = new Paragraph("State: " + customer.getState(), f10);
            Paragraph zipCode = new Paragraph("Zip Code: " + customer.getZipCode(), f10);
            Paragraph empName = new Paragraph("Employer Name: " + customer.getEmpName(), f10);
            Paragraph empSupName = new Paragraph("Employer Name: " + customer.getEmpSupName(), f10);
            Paragraph acceptTerms = new Paragraph("Agree to Conditions: " + customer.getAcceptTerms(), f10);
            Paragraph acceptTermsText = new Paragraph("By signing this document, I acknowledge that all of the information that I have provided to be true and accurate. I agree that I will hold harmless the service provider, installer, and the manufacturer of the aforementioned device in the occurrence of any of the following; physiological adverse effects, claims, attorney fees, cost, manufacturing defects, or any other injured resulting from the monitoring device, wearing the monitoring device, harming the monitoring device installed, and the like. I further agree the monitoring device is only being used for services related to my bond, parole, probation, and the like. Thus, the service provider, installer, and manufacturer possess no duty to maintain my safety, health, or well-being with the monitoring device.", f10);

            document.add(deviceSelected);
            document.add(header);
            document.add(firstName);
            document.add(lastName);
            document.add(dateOfBirth);
            document.add(sex);
            document.add(height);
            document.add(phoneNum);
            document.add(email);
            document.add(dLicenseNum);
            document.add(sSecurityNum);
            document.add(addLine1);
            document.add(addLine2);
            document.add(city);
            document.add(state);
            document.add(zipCode);
            document.add(empName);
            document.add(empSupName);
            document.add(acceptTermsText);
            document.add(acceptTerms);


            Paragraph nameSignature = new Paragraph();
            nameSignature.add(customer.getFirstName() + " " + customer.getLastName());
            nameSignature.setAlignment(450);

            // Create a buffered image
            BufferedImage image;
            byte[] imageByte;

            BASE64Decoder decoder = new BASE64Decoder();
            imageByte = decoder.decodeBuffer(customer.getSignature());
            ByteArrayInputStream bis = new ByteArrayInputStream(imageByte);
            image = ImageIO.read(bis);
            bis.close();

            // Write the image to a file
            File outputFile = new File(fileLocation + ".png");
            ImageIO.write(image, "png", outputFile);
            Image img = Image.getInstance(fileLocation + ".png");
            img.scaleAbsolute(120, 30);

            document.add(img);
            document.add(nameSignature);

            //close
            document.close();

            System.out.println("Created PDF");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/downloadPrevious")
    public void downloadPrevious(HttpServletResponse response) throws IOException {
        File file = new File(fileLocation + ".pdf");

        if (!file.exists()) {
            String errorMessage = "Sorry. The file you are looking for does not exist";
            System.out.println(errorMessage);
            OutputStream outputStream = response.getOutputStream();
            outputStream.write(fileLocation.getBytes(Charset.forName("UTF-8")));
            outputStream.close();
            return;
        }

        String mimeType = URLConnection.guessContentTypeFromName(file.getName());
        if (mimeType == null) {
            System.out.println("mimetype is not detectable, will take default");
            mimeType = "application/octet-stream";
        }

        System.out.println("mimetype : " + mimeType);

        response.setContentType(mimeType);

        /* "Content-Disposition : inline" will show viewable types [like images/text/pdf/anything viewable by browser] right on browser
            while others(zip e.g) will be directly downloaded [may provide save as popup, based on your browser setting.]*/
        response.setHeader("Content-Disposition", String.format("attachment; filename=\"" + file.getName() + "\""));


        /* "Content-Disposition : attachment" will be directly download, may provide save as popup, based on your browser setting*/
        //response.setHeader("Content-Disposition", String.format("attachment; filename=\"%s\"", file.getName()));

        response.setContentLength((int) file.length());

        InputStream inputStream = new BufferedInputStream(new FileInputStream(file));

        //Copy bytes from source to destination(outputStream in this example), closes both streams.
        FileCopyUtils.copy(inputStream, response.getOutputStream());
        System.out.println("Sent PDF to browser");
    }
}
