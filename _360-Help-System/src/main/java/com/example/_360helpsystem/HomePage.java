package com.example._360helpsystem;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class HomePage extends Application {

    @Override
    public void start(Stage primaryStage) {
        // Top bar to hold the "Home" label and "Logout" button
        HBox topBar = new HBox();
        topBar.setPadding(new Insets(5, 10, 10, 10)); // Padding for the top bar

        // "Logout" button aligned to the right
        Button logoutButton = WindowUtil.createStyledButton("Logout");
        logoutButton.setFont(WindowUtil.createStyledLabel("Logout", 18).getFont());

        // Spacer to center the "Home" label
        HBox spacerLeft = new HBox();
        HBox spacerRight = new HBox();
        HBox.setHgrow(spacerLeft, Priority.ALWAYS);
        HBox.setHgrow(spacerRight, Priority.ALWAYS);

        // "Home" label at the center
        Label homeText = WindowUtil.createStyledLabel("Home", 24);

        // Add spacerLeft, homeText, and spacerRight to center "Home"
        topBar.getChildren().addAll(spacerLeft, homeText, spacerRight, logoutButton);

        // Align the top bar elements
        topBar.setAlignment(Pos.CENTER);

        // Create the circular back button using ButtonStyleUtil
        Button backButton = ButtonStyleUtil.createCircularBackButton();

        // Handle back button action
        backButton.setOnAction(e -> showPreviousScreen(primaryStage));

        // Create a BorderPane to position the back button at the top left
        BorderPane backButtonPane = new BorderPane();
        backButtonPane.setTop(backButton);

        // Align the back button to the top-left and set padding (gap of 5)
        BorderPane.setAlignment(backButton, Pos.TOP_LEFT);
        BorderPane.setMargin(backButton, new Insets(5, 0, 0, 5));  // Gap of 5 from top and left

        // Combine topBar and backButton in a VBox to create a top layout
        VBox topLayout = new VBox();
        topLayout.getChildren().addAll(backButtonPane, topBar);

        // Set padding between the back button and the top bar
        VBox.setMargin(topBar, new Insets(5, 0, 0, 0)); // 5px space between back button and top bar

        // Create the main layout with the top bar and back button
        BorderPane root = new BorderPane();
        root.setTop(topLayout);

        // Set the scene with the required window size
        Scene scene = new Scene(root, 600, 600);  // Set to 600x600
        primaryStage.setTitle("Home Page");
        primaryStage.setScene(scene);
        primaryStage.show();

        // Set action for the logout button to show the SignIn screen
        logoutButton.setOnAction(e -> showSignInScreen(primaryStage));
    }

    // Method to show the SignIn screen when Logout is clicked
    private void showSignInScreen(Stage primaryStage) {
        SignIn signIn = new SignIn();
        try {
            signIn.start(primaryStage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    // Method to handle back button logic
    private void showPreviousScreen(Stage primaryStage) {
        SignInAs signInAs = new SignInAs();
        try {
            signInAs.start(primaryStage);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

    }
}