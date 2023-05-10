
package milestone.pkg3;

import com.itextpdf.io.font.FontConstants;
import com.itextpdf.io.image.ImageData;
import com.itextpdf.io.image.ImageDataFactory;
import com.itextpdf.kernel.color.Color;
import com.itextpdf.kernel.font.PdfFont;
import com.itextpdf.kernel.font.PdfFontFactory;
import com.itextpdf.kernel.pdf.PdfDocument;
import com.itextpdf.kernel.pdf.PdfWriter;
import com.itextpdf.layout.Document;
import com.itextpdf.layout.element.Cell;
import com.itextpdf.layout.element.Image;
import com.itextpdf.layout.element.List;
import com.itextpdf.layout.element.Paragraph;
import com.itextpdf.layout.element.Table;
import com.itextpdf.layout.element.Text;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.util.Optional;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author DELL
 */
public class CreateRecipeController implements Initializable {

    @FXML
    private TextField ChefNameTxt;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void CreateOnButtonClicked(ActionEvent event) {

        try {

            FileChooser fc = new FileChooser();
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PDF files", "*.pdf"));
            fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image files", "*.jpg", "*.bmp", "*.png"));
            File f = fc.showSaveDialog(null);
            if (f != null) {
                PdfWriter pw = new PdfWriter(new FileOutputStream(f));
                //PdfWriter pw = new PdfWriter(new FileOutputStream("testPDF.pdf"));
                PdfDocument pdf = new PdfDocument(pw);
                pdf.addNewPage();
                Document doc = new Document(pdf);
                doc.setLeftMargin(30);

                //----------------------------------------------------
                //adding paragrapg to the pdf
                String newline = "\n";
                Paragraph lineSpace = new Paragraph(newline);
                lineSpace.setHeight(8);

                String paraText1
                        = "Ingredients: \n"
                        + "− 3½ pounds boneless beef chuck, cut into bite-size pieces\n"
                        + "− ½ cup flour \n"
                        + "− ½ teaspoon salt \n"
                        + "− Freshly ground pepper \n"
                        + "− 6 tablespoons unsalted butter \n"
                        + "− 2 medium onions, chopped \n"
                        + "− 4 cups cold water";

                Paragraph para1 = new Paragraph(paraText1);

                Text titleText = new Text("RECIPE FOR BEEF STEW");
                titleText.setFontSize(25f);
                Paragraph pageTitle = new Paragraph(titleText);
                titleText.setBold();

                PdfFont font2 = PdfFontFactory.createFont(FontConstants.TIMES_ROMAN);
                PdfFont fontBold = PdfFontFactory.createFont(FontConstants.TIMES_BOLD);
                Text title = new Text("Recipe made by: ").setFont(fontBold);
                Text author = new Text(ChefNameTxt.getText()).setFont(font2);
                author.setFontColor(Color.BLUE);
                Paragraph bookInfo = new Paragraph().add(title).add(author);

                doc.add(pageTitle);
                doc.add(lineSpace);
                doc.add(para1);
                doc.add(lineSpace);
                doc.add(bookInfo);
                doc.add(lineSpace);

                //----------------------------------------------------
                //adding a list
                List progLangList = new List();
                progLangList.add("DIRECTION: ").setFont(font2).setFontColor(Color.BLUE);
                progLangList.add("1. Coat bite-size pieces of beef with flour; season with salt and pepper. \n");
                progLangList.add("2. In a large heavy flameproof baking casserole or stew pot, melt butter over\n");
                progLangList.add("medium-high heat.\n");
                progLangList.add("3. Add the meat, in batches if necessary; brown on all sides, about 8 minutes total.\n");
                progLangList.add("4. Add onion; cook, stirring and scraping bottom of the pot until softened, about 4\n");
                progLangList.add("minutes.\n");
                progLangList.add("5. Pour in water to barely cover; reduce heat to low. Stir a bit then simmer, partially\n");
                progLangList.add("covered, until tender, about 2 hours.\n");
                progLangList.add("6. Check for seasoning. Finish with one of the variations below.");
                doc.add(progLangList);
                doc.add(lineSpace);

                Alert a = new Alert(Alert.AlertType.CONFIRMATION);
                a.setContentText("Do you want to add an Image?");
                Optional<ButtonType> result = a.showAndWait();
                if (result.get() == ButtonType.OK) {
                    File imageFile = fc.showOpenDialog(null);
                    String imagePath = imageFile.getAbsolutePath();
                    ImageData data = ImageDataFactory.create(imagePath);
                    Image image = new Image(data);
                    image.setAutoScale(true);

                    doc.add(image);
                    doc.add(lineSpace);
                    a = new Alert(Alert.AlertType.INFORMATION);
                    a.setContentText("Image added.");
                    a.showAndWait();
                }
                //----------------------------------------------------

                //adding table in pdf
                float colWidthArr[] = {70f, 200f, 100f};
                Table pdfTable = new Table(colWidthArr);

                //adding header row
                Cell cell_00 = new Cell();
                cell_00.add("Stew Type");
                cell_00.setBackgroundColor(Color.BLUE);
                pdfTable.addCell(cell_00);
                pdfTable.addCell(new Cell().setBackgroundColor(Color.BLUE).add("Calories"));
                pdfTable.addCell(new Cell().setBackgroundColor(Color.BLUE).add("Protein:Carbohydrate"));

                //adding content row
                pdfTable.addCell(new Cell().add("American"));
                pdfTable.addCell(new Cell().add("358"));
                pdfTable.addCell(new Cell().add("41g:17g"));

                //adding content row
                pdfTable.addCell(new Cell().add("Italian"));
                pdfTable.addCell(new Cell().add("366"));
                pdfTable.addCell(new Cell().add("41g:7g"));

                //adding content row
                pdfTable.addCell(new Cell().add("Spanish"));
                pdfTable.addCell(new Cell().add("409"));
                pdfTable.addCell(new Cell().add("41g:21g"));

                doc.add(pdfTable);

                doc.close();

                a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("The PDF is saved successfully.");
                a.showAndWait();
            } else {
                Alert a = new Alert(Alert.AlertType.INFORMATION);
                a.setContentText("Saving as PDF: cancelled!");
                a.showAndWait();
            }
        } catch (Exception e) {
            Alert a = new Alert(Alert.AlertType.INFORMATION);
            a.setContentText("Oops! Exception: " + e.toString() + " occured.");
            a.showAndWait();
            //System.out.println("Something went wrong...");
            //System.out.println(e);
        }

    }
private void ChangeScene(ActionEvent event, String str) throws IOException {

        try {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource(str + ".fxml"));
            Parent root = loader.load();
            Scene scene = new Scene(root);
            Stage window = (Stage) ((Node) event.getSource()).getScene().getWindow();
            window.setScene(scene);
            window.show();

        } catch (ClassCastException ex) {
            Logger.getLogger(MissionAllocationController.class
                    .getName()).log(Level.SEVERE, null, ex);
        }
    
}
    @FXML
    private void gotodashboard(ActionEvent event) throws IOException {
        ChangeScene(event,"DashboardforCook");
    }

}
