package dibujon;

import java.nio.file.Path;
import javafx.animation.PathTransition;
import javafx.application.Application;
import static javafx.application.Application.launch;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.paint.LinearGradient;
import javafx.scene.paint.Stop;
import javafx.scene.shape.Arc;
import javafx.scene.shape.ArcTo;
import javafx.scene.shape.Circle;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.HLineTo;
import javafx.scene.shape.Line;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.QuadCurveTo;
import javafx.scene.shape.VLineTo;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.QuadCurve;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 *
 * @author Leonardo Galicia
 */
public class DibujoN extends Application {
    
    @Override
    public void start(Stage primaryStage) {           
       Pane root = new Pane();
 
       javafx.scene.shape.Path pc = new javafx.scene.shape.Path();
       MoveTo ini = new MoveTo(); 
       ini.setX(254.0f);
       ini.setY(0.0f);
       LineTo lt = new LineTo(254,100);
       //Control X1: 350.0 Control Y1: 265.0 Control X2: 231.0 Control Y2: 212.0
       CubicCurveTo cct = new CubicCurveTo();
       cct.setControlX1(330);
       cct.setControlY1(265);
       cct.setControlX2(799);
       cct.setControlY2(299);
       cct.setX(874);
       cct.setY(100);
       CubicCurveTo cct2 = new CubicCurveTo();
       cct2.setControlX1(370);
       cct2.setControlY1(255);
       cct2.setControlX2(290);
       cct2.setControlY2(360);
       cct2.setX(774);
       cct2.setY(50);
       VLineTo vlt = new VLineTo();
       vlt.setY(120);
       QuadCurveTo qct = new QuadCurveTo();
       qct.setControlX(650.0f);
       qct.setControlY(155.0f);
       qct.setX(594.0f);
       qct.setY(182.0f);
       VLineTo vlt2 = new VLineTo();
       vlt2.setY(5);  
       pc.getElements().addAll(ini,vlt,cct,vlt2);
       
       javafx.scene.shape.Path pc2 = new javafx.scene.shape.Path();
       MoveTo ini0 = new MoveTo(); 
       ini0.setX(265.0f);
       ini0.setY(0.0f);
       LineTo lt0 = new LineTo(252,100);
       QuadCurveTo qct0 = new QuadCurveTo();
       qct0.setControlX(250.0f);
       qct0.setControlY(220.0f);
       qct0.setX(572.0f);
       qct0.setY(244.0f);
       QuadCurveTo qct1 = new QuadCurveTo();
       qct1.setControlX(814.0f);
       qct1.setControlY(240.0f);
       qct1.setX(880.0f);
       qct1.setY(135.0f);
       VLineTo vlt0 = new VLineTo();
       vlt0.setY(0);
       pc2.getElements().addAll(ini0,lt0,qct0,qct1,vlt0);
       pc2.setFill(Color.BLACK);
       
       javafx.scene.shape.Path cin = new javafx.scene.shape.Path();
       MoveTo ini2 = new MoveTo(); 
       ini2.setX(350.0f);
       ini2.setY(0.0f);
       VLineTo vlt3 = new VLineTo();
       vlt3.setY(90);
       QuadCurveTo qct2 = new QuadCurveTo();
       qct2.setControlX(350.0f);
       qct2.setControlY(180.0f);
       qct2.setX(590.0f);
       qct2.setY(175.0f);
       QuadCurveTo qct3 = new QuadCurveTo();
       qct3.setControlX(790.0f);
       qct3.setControlY(172.0f);
       qct3.setX(780.0f);
       qct3.setY(100.0f);
       VLineTo vlt4 = new VLineTo();
       vlt4.setY(2);
       cin.getElements().addAll(ini2,vlt3,qct2,qct3,vlt4);
       Stop[] stops5 = new Stop[] { new Stop(0, Color.web("#D5D4C0")), new Stop(1, Color.web("#A4A49A")), new Stop(.1, Color.web("#C8C8BB")), new Stop(.2, Color.web("#D7D7D1")), new Stop(.4, Color.web("#A8A89A"))};
       LinearGradient lg15 = new LinearGradient(0, 0, 1, 0, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops5);
       cin.setFill(Color.GREY);//setFill(lg13);
       
       javafx.scene.shape.Path pelo = new javafx.scene.shape.Path();
       MoveTo ini3 = new MoveTo(); 
       ini3.setX(220.0f);
       ini3.setY(1.0f);
       LineTo lt2 = new LineTo();
       lt2.setX(190);
       lt2.setY(130);
       //VLineTo vlt5 = new VLineTo();
       //vlt5.setY(0);
       LineTo lt3 = new LineTo();
       lt3.setX(285);
       lt3.setY(2);
       HLineTo hlt = new HLineTo();
       hlt.setX(320);
       
       LineTo lt4 = new LineTo();
       lt4.setX(260);
       lt4.setY(240);
       LineTo lt5 = new LineTo();
       lt5.setX(400);
       lt5.setY(2);
       HLineTo hlt2 = new HLineTo();
       hlt2.setX(720);
       LineTo lt6 = new LineTo();
       lt6.setX(700);
       lt6.setY(200);
       LineTo lt7 = new LineTo();
       lt7.setX(790);
       lt7.setY(2);
       HLineTo hlt3 = new HLineTo();
       hlt3.setX(800);
       VLineTo vlt5 = new VLineTo();
       vlt5.setY(195);
       LineTo lt8 = new LineTo();
       lt8.setX(850);
       lt8.setY(40);
       LineTo lt9 = new LineTo();
       lt9.setX(885);
       lt9.setY(150);
       LineTo lt10 = new LineTo();
       lt10.setX(915);
       lt10.setY(2);
       pelo.getElements().addAll(ini3,lt2,lt3,hlt,lt4,lt5,hlt2,lt6,lt7,hlt3,vlt5,lt8,lt9,lt10);
       
       pc.setFill(Color.BLACK);
       
       
       Stop[] stops2 = new Stop[] { new Stop(0, Color.web("#F9E79F")), new Stop(1, Color.web("#F3E40B")), new Stop(.1, Color.web("#F4D03F")), new Stop(.2, Color.web("#F4D03F")), new Stop(.4, Color.web("#F4D03F"))};
       LinearGradient lg12 = new LinearGradient(0, 0, 1, 0, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops2);
       pelo.setFill(Color.web("#FFCC00"));
       
       
       javafx.scene.shape.Path cara = new javafx.scene.shape.Path();
       MoveTo ini4 = new MoveTo(); 
       ini4.setX(300.0f);
       ini4.setY(160.0f);
       LineTo lt11 = new LineTo();
       lt11.setX(313);
       lt11.setY(375);
       /*VLineTo vlt6 = new VLineTo();
       vlt6.setY(375);*/
       /*CubicCurveTo cct3 = new CubicCurveTo();
       cct3.setControlX1(257);
       cct3.setControlY1(1000);
       cct3.setControlX2(790);
       cct3.setControlY2(920);
       cct3.setX(100.0f);
       cct3.setY(650.0f);*/
       QuadCurveTo qct4 = new QuadCurveTo();
       qct4.setControlX(394.0f);
       qct4.setControlY(795.0f);
       qct4.setX(561.0f);
       qct4.setY(819.0f);
       HLineTo hlt4 = new HLineTo();
       hlt4.setX(578);
       QuadCurveTo qct5 = new QuadCurveTo();
       qct5.setControlX(765.0f);
       qct5.setControlY(779.0f);
       qct5.setX(832.0f);
       qct5.setY(330.0f);
       VLineTo vlt6 = new VLineTo();
       vlt6.setY(162);
       HLineTo hlt5 = new HLineTo();
       hlt5.setX(298);
       //Control X1: 415.0 Control Y1: 713.0 Control X2: 352.0 Control Y2: 678.0
       cara.getElements().addAll(ini4,lt11,qct4,hlt4,qct5,vlt6,hlt5);
       
       Stop[] stops6 = new Stop[] { new Stop(0, Color.web("#ffdab9")), new Stop(1, Color.web("#ffdab9")), new Stop(.1, Color.web("#fad7c2")), new Stop(.2, Color.web("#fad7c2")), new Stop(.4, Color.web("#f5bb99"))};
       LinearGradient lg16 = new LinearGradient(0, 0, 1, 0, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops6);
       
       cara.setFill(Color.web("#F5CBA7"));
       
       
       javafx.scene.shape.Path pelo2 = new javafx.scene.shape.Path();
       MoveTo ini5 = new MoveTo(); 
       ini5.setX(320.0f);
       ini5.setY(400.0f);
       HLineTo hlt6 = new HLineTo();
       hlt6.setX(295);
       LineTo lt12 = new LineTo();
       lt12.setX(257);
       lt12.setY(515);
       LineTo lt13 = new LineTo();
       lt13.setX(360);
       lt13.setY(425);
       HLineTo hlt7 = new HLineTo();
       hlt7.setX(310);
       LineTo lt14 = new LineTo();
       lt14.setX(285);
       lt14.setY(600);
       LineTo lt15 = new LineTo();
       lt15.setX(330);
       lt15.setY(550);
       LineTo lt16 = new LineTo();
       lt16.setX(290);
       lt16.setY(678);
       LineTo lt17 = new LineTo();
       lt17.setX(345);
       lt17.setY(600);
       LineTo lt18 = new LineTo();
       lt18.setX(327);
       lt18.setY(700);
       LineTo lt19 = new LineTo();
       lt19.setX(400);
       lt19.setY(600);
       
       pelo2.getElements().addAll(ini5,hlt6,lt12,lt13,hlt7,lt14,lt15,lt16,lt17,lt18,lt19);
       
       pelo2.setStroke(Color.YELLOW);
       Stop[] stops3 = new Stop[] { new Stop(0, Color.web("#F7EA3B")), new Stop(1, Color.web("#F7EA3B")), new Stop(.1, Color.web("#EFE348")), new Stop(.2, Color.web("#EFE348")), new Stop(.4, Color.web("#EFE348"))};
       LinearGradient lg13 = new LinearGradient(0, 0, 1, 0, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops2);
       pelo2.setFill(Color.web("#FFCC00"));
       
       javafx.scene.shape.Path pelo3 = new javafx.scene.shape.Path();
       MoveTo ini6 = new MoveTo(); 
       ini6.setX(830.0f);
       ini6.setY(400.0f);
       VLineTo vlt7 = new VLineTo();
       vlt7.setY(645);
       LineTo lt20 = new LineTo();
       lt20.setX(808);
       lt20.setY(570);
       VLineTo vlt8 = new VLineTo();
       vlt8.setY(730);
       LineTo lt21 = new LineTo();
       lt21.setX(708);
       lt21.setY(500);
       
       pelo3.getElements().addAll(ini6,vlt7,lt20,vlt8,lt21);
       Stop[] stops4 = new Stop[] { new Stop(0, Color.web("#F7EA3B")), new Stop(1, Color.web("#F7EA3B")), new Stop(.1, Color.web("#EFE348")), new Stop(.2, Color.web("#EFE348")), new Stop(.4, Color.web("#EFE348"))};
       LinearGradient lg14 = new LinearGradient(0, 0, 1, 0, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops4);
       pelo3.setFill(Color.web("#FFCC00"));
       
       Line l = new Line();
       l.setStartX(420);
       l.setStartY(420);
       l.setEndX(335);
       l.setEndY(460);
       l.setStrokeWidth(5);
       
       Line l2 = new Line();
       l2.setStartX(430);
       l2.setStartY(490);
       l2.setEndX(360);
       l2.setEndY(550);
       l2.setStrokeWidth(5);
       
       Line l3 = new Line();
       l3.setStartX(445);
       l3.setStartY(566);
       l3.setEndX(392);
       l3.setEndY(640);
       l3.setStrokeWidth(5);
       
       Line l4 = new Line();
       l4.setStartX(805);
       l4.setStartY(464);
       l4.setEndX(715);
       l4.setEndY(429);
       l4.setStrokeWidth(5);
       
       Line l5 = new Line();
       l5.setStartX(700);
       l5.setStartY(491);
       l5.setEndX(780);
       l5.setEndY(565);
       l5.setStrokeWidth(5);
       
       Line l6 = new Line();
       l6.setStartX(690);
       l6.setStartY(560);
       l6.setEndX(745);
       l6.setEndY(635);
       l6.setStrokeWidth(5);
       
       javafx.scene.shape.Path pelo4 = new javafx.scene.shape.Path();
       MoveTo ini7 = new MoveTo(); 
       ini7.setX(270.0f);
       ini7.setY(140.0f);
       VLineTo vlt9 = new VLineTo();
       vlt9.setY(305);
       LineTo lt22 = new LineTo();
       lt22.setX(280);
       lt22.setY(270);
       LineTo lt23 = new LineTo();
       lt23.setX(318);
       lt23.setY(420);
       LineTo lt24 = new LineTo();
       lt24.setX(300);
       lt24.setY(172);
       
       pelo4.getElements().addAll(ini7,vlt9,lt22,lt23,lt24);
       pelo4.setFill(Color.web("#FFCC00"));
       
       javafx.scene.shape.Path pelo5 = new javafx.scene.shape.Path();
       MoveTo ini8 = new MoveTo(); 
       ini8.setX(870.0f);
       ini8.setY(110.0f);
       LineTo lt25 = new LineTo();
       lt25.setX(850);
       lt25.setY(323);
       LineTo lt26 = new LineTo();
       lt26.setX(844);
       lt26.setY(310);
       LineTo lt27 = new LineTo();
       lt27.setX(830);
       lt27.setY(395);
       LineTo lt28 = new LineTo();
       lt28.setX(830);
       lt28.setY(155);      
       pelo5.getElements().addAll(ini8,lt25,lt26,lt27,lt28);
       pelo5.setFill(Color.web("#FFCC00"));
       
       javafx.scene.shape.Path ojo = new javafx.scene.shape.Path();
       MoveTo ini9 = new MoveTo(); 
       ini9.setX(320.0f);
       ini9.setY(215.0f);
       QuadCurveTo qct6 = new QuadCurveTo();
       qct6.setControlX(320.0f);
       qct6.setControlY(380.0f);
       qct6.setX(485.0f);
       qct6.setY(345.0f);
       QuadCurveTo qct7 = new QuadCurveTo();
       qct7.setControlX(450.0f);
       qct7.setControlY(145.0f);
       qct7.setX(325.0f);
       qct7.setY(210.0f);
       ojo.getElements().addAll(ini9,qct6,qct7); //hlt8
       ojo.setFill(Color.CHOCOLATE);
       ojo.setStroke(Color.BLACK);
       //ojo.setStrokeWidth(4);
       
       javafx.scene.shape.Path ojo2 = new javafx.scene.shape.Path();
       MoveTo ini10 = new MoveTo(); 
       ini10.setX(360.0f);
       ini10.setY(255.0f);
       QuadCurveTo qct8 = new QuadCurveTo();
       qct8.setControlX(345.0f);
       qct8.setControlY(385.0f);
       qct8.setX(485.0f);
       qct8.setY(345.0f);
       QuadCurveTo qct9 = new QuadCurveTo();
       qct9.setControlX(450.0f);
       qct9.setControlY(170.0f);
       qct9.setX(360.0f);
       qct9.setY(260.0f);
       ojo2.getElements().addAll(ini10,qct8,qct9);
       Stop[] stops29 = new Stop[] { new Stop(0, Color.web("#F9F0E9")), new Stop(1, Color.web("#FAFAFA")), new Stop(.1, Color.web("#FFFFFF")), new Stop(.2, Color.web("#EEFFF9")), new Stop(.4, Color.web("#FFFFFF"))};
       LinearGradient lg29 = new LinearGradient(0, 0, 1, 0, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops29);
       
       ojo2.setFill(Color.WHITE);
       ojo2.setStroke(Color.BLACK);
       ojo2.setStrokeWidth(4);
       //nose toca
       javafx.scene.shape.Path ojo3 = new javafx.scene.shape.Path();
       MoveTo ini11 = new MoveTo(); 
       ini11.setX(830.0f);
       ini11.setY(220.0f);
       QuadCurveTo qct10 = new QuadCurveTo();
       qct10.setControlX(820.0f);
       qct10.setControlY(390.0f);
       qct10.setX(657.0f);
       qct10.setY(360.0f);//nose toca
       QuadCurveTo qct11 = new QuadCurveTo();
       qct11.setControlX(670.0f);
       qct11.setControlY(160.0f);
       qct11.setX(825.0f);
       qct11.setY(210.0f);
       ojo3.getElements().addAll(ini11,qct10,qct11);
       ojo3.setFill(Color.CHOCOLATE); 
       ojo3.setStroke(Color.BLACK);
       //ojo3.setStrokeWidth(4);
       
       javafx.scene.shape.Path ojo4 = new javafx.scene.shape.Path();
       MoveTo ini12 = new MoveTo(); 
       ini12.setX(784.0f);
       ini12.setY(265.0f);
       QuadCurveTo qct12 = new QuadCurveTo();
       qct12.setControlX(790.0f);
       qct12.setControlY(388.0f);
       qct12.setX(657.0f);
       qct12.setY(360.0f);//nose toca
       QuadCurveTo qct13 = new QuadCurveTo();
       qct13.setControlX(665.0f);
       qct13.setControlY(195.0f);
       qct13.setX(784.0f);
       qct13.setY(265.0f);
       ojo4.getElements().addAll(ini12,qct12,qct13);
       ojo4.setFill(Color.WHITE); 
       ojo4.setStroke(Color.BLACK);
       ojo4.setStrokeWidth(4);
       
       javafx.scene.shape.Path ropa = new javafx.scene.shape.Path();
       MoveTo ini13 = new MoveTo(); 
       ini13.setX(350.0f);
       ini13.setY(850.0f);
       VLineTo vlt10 = new VLineTo();
       vlt10.setY(700);
       QuadCurveTo qct14 = new QuadCurveTo();
       qct14.setControlX(364.0f);
       qct14.setControlY(590.0f);
       qct14.setX(379.0f);
       qct14.setY(615.0f);
       QuadCurveTo qct15 = new QuadCurveTo();
       qct15.setControlX(794.0f);
       qct15.setControlY(580.0f);
       qct15.setX(770.0f);
       qct15.setY(850.0f);
       HLineTo hlt8 = new HLineTo();
       hlt8.setX(762);
       ropa.getElements().addAll(ini13,vlt10,qct14,hlt8,qct15);
       ropa.setFill(Color.BLACK);
       ropa.setStroke(Color.GRAY);
       ropa.setStrokeWidth(4);
       
       javafx.scene.shape.Path ropa2 = new javafx.scene.shape.Path();
       MoveTo ini14 = new MoveTo(); 
       ini14.setX(392.0f);
       ini14.setY(648.0f);
       VLineTo vlt11 = new VLineTo();
       vlt11.setY(720);
       LineTo lt29 = new LineTo();
       lt29.setX(410);
       lt29.setY(740);
       VLineTo vlt12 = new VLineTo();
       vlt12.setY(750);
       LineTo lt30 = new LineTo();
       lt30.setX(420);
       lt30.setY(760);
       LineTo lt31 = new LineTo();
       lt31.setX(430);
       lt31.setY(748);
       LineTo lt32 = new LineTo();
       lt32.setX(455);
       lt32.setY(774);
       LineTo lt33 = new LineTo();
       lt33.setX(458);
       lt33.setY(794);
       LineTo lt34 = new LineTo();
       lt34.setX(468);
       lt34.setY(794);
       LineTo lt35 = new LineTo();
       lt35.setX(470);
       lt35.setY(784);
       HLineTo hlt9 = new HLineTo();
       hlt9.setX(644);
       VLineTo vlt13 = new VLineTo();
       vlt13.setY(790);
       HLineTo hlt10 = new HLineTo();
       hlt10.setX(655);
       VLineTo vlt14 = new VLineTo();
       vlt14.setY(795);
       HLineTo hlt11 = new HLineTo();
       hlt11.setX(660);
       VLineTo vlt15 = new VLineTo();
       vlt15.setY(780);
       LineTo lt36 = new LineTo();
       lt36.setX(695);
       lt36.setY(762);
       LineTo lt37 = new LineTo();
       lt37.setX(700);
       lt37.setY(770);
       LineTo lt38 = new LineTo();
       lt38.setX(707);
       lt38.setY(769);
       LineTo lt39 = new LineTo();
       lt39.setX(710);
       lt39.setY(755);
       LineTo lt40 = new LineTo();
       lt40.setX(735);
       lt40.setY(725);
       VLineTo vlt16 = new VLineTo();
       vlt16.setY(650);
       ropa2.getElements().addAll(ini14,vlt11,lt29,vlt12,lt30,lt31,lt32,lt33,lt34,lt35,hlt9,vlt13,hlt10,vlt14,hlt11,vlt15,lt36,lt37,lt38,lt39,lt40,vlt16);
       ropa2.setFill(Color.BLACK);
       ropa2.setStroke(Color.GRAY);
       ropa2.setStrokeWidth(4);
       
       ///////no tocar///////////////////////////////////
       
       javafx.scene.shape.Path ropa3 = new javafx.scene.shape.Path();
       MoveTo ini15 = new MoveTo(); 
       ini15.setX(350.0f);
       ini15.setY(734.0f);
       LineTo lt42 = new LineTo();
       lt42.setX(275);
       lt42.setY(777);
       QuadCurveTo qct21 = new QuadCurveTo();
       qct21.setControlX(94.0f);
       qct21.setControlY(812.0f);
       qct21.setX(80.0f);
       qct21.setY(850.0f);
       HLineTo hlt12 = new HLineTo();
       hlt12.setX(350);
       ropa3.getElements().addAll(ini15,lt42,qct21,hlt12);
       ropa3.setFill(Color.web("#DC332E"));
       
       javafx.scene.shape.Path ropa4 = new javafx.scene.shape.Path();
       MoveTo ini18 = new MoveTo(); 
       ini18.setX(781.0f);
       ini18.setY(731.0f);
       LineTo lt43 = new LineTo();
       lt43.setX(895);
       lt43.setY(810);
       QuadCurveTo qct22 = new QuadCurveTo();
       qct22.setControlX(994.0f);
       qct22.setControlY(822.0f);
       qct22.setX(1000.0f);
       qct22.setY(850.0f);
       HLineTo hlt13 = new HLineTo();
       hlt13.setX(780);
       ropa4.getElements().addAll(ini18,lt43,qct22,hlt13);
       ropa4.setFill(Color.web("#B97954"));
       
       javafx.scene.shape.Path ropa5 = new javafx.scene.shape.Path();
       MoveTo ini19 = new MoveTo(); 
       ini19.setX(780.0f);
       ini19.setY(731.0f);
       LineTo lt44 = new LineTo();
       lt44.setX(790);
       lt44.setY(740);
       LineTo lt45 = new LineTo();
       lt45.setX(815);
       lt45.setY(849);
       HLineTo hlt14 = new HLineTo();
       hlt14.setX(765);
       ropa5.getElements().addAll(ini19,lt44,lt45,hlt14);
       ropa5.setFill(Color.web("#B56638"));
       
       //OREJAS
       javafx.scene.shape.Path oreja = new javafx.scene.shape.Path();
       MoveTo ini16 = new MoveTo(); 
       ini16.setX(262.0f);
       ini16.setY(132.0f);
       QuadCurveTo qct16 = new QuadCurveTo();
       qct16.setControlX(204.0f);
       qct16.setControlY(320.0f);
       qct16.setX(312.0f);
       qct16.setY(475.0f);
       QuadCurveTo qct17 = new QuadCurveTo();
       qct17.setControlX(324.0f);
       qct17.setControlY(486.0f);
       qct17.setX(370.0f);
       qct17.setY(444.0f);
       oreja.getElements().addAll(ini16,qct16,qct17);
       oreja.setFill(Color.BISQUE);
       
       javafx.scene.shape.Path oreja2 = new javafx.scene.shape.Path();
       MoveTo ini17 = new MoveTo(); 
       ini17.setX(865.0f);
       ini17.setY(142.0f);
       QuadCurveTo qct18 = new QuadCurveTo();
       qct18.setControlX(940.0f);
       qct18.setControlY(80.0f);
       qct18.setX(862.0f);
       qct18.setY(390.0f);
       QuadCurveTo qct19 = new QuadCurveTo();
       qct19.setControlX(324.0f);
       qct19.setControlY(486.0f);
       qct19.setX(370.0f);
       qct19.setY(444.0f);
       QuadCurveTo qct20 = new QuadCurveTo();
       qct20.setControlX(834.0f);
       qct20.setControlY(486.0f);
       qct20.setX(810.0f);
       qct20.setY(444.0f);
       oreja2.getElements().addAll(ini17,qct18,qct20);
       oreja2.setFill(Color.BISQUE);
       
       javafx.scene.shape.Path cejas = new javafx.scene.shape.Path();
       MoveTo ini20 = new MoveTo(); 
       ini20.setX(428.0f);
       ini20.setY(225.0f);
       LineTo lt46 = new LineTo();
       lt46.setX(468);
       lt46.setY(232);
       LineTo lt47 = new LineTo();
       lt47.setX(532);
       lt47.setY(302);
       ArcTo at = new ArcTo();
       at.setX(525.0);
       at.setY(315.0);
       at.setRadiusX(980.0);
       at.setRadiusY(800.0);
       LineTo lt48 = new LineTo();
       lt48.setX(425);
       lt48.setY(225);
       cejas.getElements().addAll(ini20,lt46,lt47,at,lt48);
       cejas.setFill(Color.YELLOW);
       
       javafx.scene.shape.Path cejas2 = new javafx.scene.shape.Path();
       MoveTo ini21 = new MoveTo(); 
       ini21.setX(720.0f);
       ini21.setY(229.0f);
       LineTo lt49 = new LineTo();
       lt49.setX(674);
       lt49.setY(242);
       LineTo lt50 = new LineTo();
       lt50.setX(610);
       lt50.setY(298);
       LineTo lt51 = new LineTo();
       lt51.setX(620);
       lt51.setY(308);
       LineTo lt52 = new LineTo();
       lt52.setX(725);
       lt52.setY(230);
       cejas2.getElements().addAll(ini21,lt49,lt50,lt51,lt52);
       cejas2.setFill(Color.YELLOW);
       
       javafx.scene.shape.Path cin2 = new javafx.scene.shape.Path();
       MoveTo ini22 = new MoveTo(); 
       ini22.setX(0.0f);
       ini22.setY(34.0f);
       QuadCurveTo qct23 = new QuadCurveTo();
       qct23.setControlX(80.0f);
       qct23.setControlY(20.0f);
       qct23.setX(253.0f);
       qct23.setY(170.0f);
       LineTo lt53 = new LineTo();
       lt53.setX(250);
       lt53.setY(192);
       QuadCurveTo qct24 = new QuadCurveTo();
       qct24.setControlX(70.0f);
       qct24.setControlY(30.0f);
       qct24.setX(1.0f);
       qct24.setY(100.0f);
       cin2.getElements().addAll(ini22,qct23,lt53,qct24);
       cin2.setFill(Color.BLACK);
       
       javafx.scene.shape.Path cin3 = new javafx.scene.shape.Path();
       MoveTo ini23 = new MoveTo(); 
       ini23.setX(0.0f);
       ini23.setY(525.0f);
       QuadCurveTo qct25 = new QuadCurveTo();
       qct25.setControlX(100.0f);
       qct25.setControlY(420.0f);
       qct25.setX(264.0f);
       qct25.setY(380.0f);
       VLineTo vlt17 = new VLineTo();
       vlt17.setY(338);
       LineTo lt54 = new LineTo();
       lt54.setY(438);
       lt54.setX(0);
       VLineTo vlt18 = new VLineTo();
       vlt18.setY(530);
       cin3.getElements().addAll(ini23,qct25,vlt17,lt54,vlt18);
       cin3.setFill(Color.BLACK);
       
       javafx.scene.shape.Path logo = new javafx.scene.shape.Path();
       MoveTo ini24 = new MoveTo(); 
       ini24.setX(600.0f);
       ini24.setY(76.0f);
       QuadCurveTo qct26 = new QuadCurveTo();
       qct26.setControlX(542.0f);
       qct26.setControlY(98.0f);
       qct26.setX(570.0f);
       qct26.setY(35.0f);
       QuadCurveTo qct27 = new QuadCurveTo();
       qct27.setControlX(587.0f);
       qct27.setControlY(10.0f);
       qct27.setX(620.0f);
       qct27.setY(35);
       QuadCurveTo qct28 = new QuadCurveTo();
       qct28.setControlX(647.0f);
       qct28.setControlY(80.0f);
       qct28.setX(600.0f);
       qct28.setY(125);
       QuadCurveTo qct29 = new QuadCurveTo();
       qct29.setControlX(560.0f);
       qct29.setControlY(140.0f);
       qct29.setX(550.0f);
       qct29.setY(120);
       logo.getElements().addAll(ini24,qct26,qct27,qct28,qct29);
       
       QuadCurve qc = new QuadCurve();
       qc.setStartX (480.0f);
       qc.setStartY (660.0f);
       qc.setEndX (648.0f);
       qc.setEndY (660.0f);
       qc.setControlX (555.0f);
       qc.setControlY (645.0f);
       qc.setFill(Color.TRANSPARENT);
       qc.setStroke(Color.BLACK);
       qc.setStrokeWidth(4);
       //efectos orejas////////////
       QuadCurve qc2 = new QuadCurve();
       qc2.setStartX (270.0f);
       qc2.setStartY (200.0f);
       qc2.setEndX (260.0f);
       qc2.setEndY (224.0f);
       qc2.setControlX (255.0f);
       qc2.setControlY (195.0f);
       qc2.setFill(Color.TRANSPARENT);
       qc2.setStroke(Color.BLACK);
       //qc2.setStrokeWidth(4);
       QuadCurve qc3 = new QuadCurve();
       qc3.setStartX (270.0f);
       qc3.setStartY (250.0f);
       qc3.setEndX (302.0f);
       qc3.setEndY (388.0f);
       qc3.setControlX (240.0f);
       qc3.setControlY (255.0f);
       qc3.setFill(Color.TRANSPARENT);
       qc3.setStroke(Color.BLACK);
       
       QuadCurve qc4 = new QuadCurve();
       qc4.setStartX (548.0f);
       qc4.setStartY (250.0f);
       qc4.setEndX (538.0f);
       qc4.setEndY (301.0f);
       qc4.setControlX (550.0f);
       qc4.setControlY (295.0f);
       qc4.setFill(Color.TRANSPARENT);
       qc4.setStroke(Color.BLACK);
       
       QuadCurve qc5 = new QuadCurve();
       qc5.setStartX (595.0f);
       qc5.setStartY (253.0f);
       qc5.setEndX (612.0f);
       qc5.setEndY (308.0f);
       qc5.setControlX (590.0f);
       qc5.setControlY (310.0f);
       qc5.setFill(Color.TRANSPARENT);
       qc5.setStroke(Color.BLACK);
       
       QuadCurve qc6 = new QuadCurve();
       qc6.setStartX(625.0f);
       qc6.setStartY(312.0f);
       qc6.setEndX(598.0f);
       qc6.setEndY(373.0f);
       qc6.setControlX(590.0f);
       qc6.setControlY(345.0f);
       qc6.setFill(Color.TRANSPARENT);
       qc6.setStroke(Color.BLACK);
       
       QuadCurve qc7 = new QuadCurve();
       qc7.setStartX(860.0f);
       qc7.setStartY(232.0f);
       qc7.setEndX(842.0f);
       qc7.setEndY(385.0f);
       qc7.setControlX(900.0f);
       qc7.setControlY(225.0f);
       qc7.setFill(Color.TRANSPARENT);
       qc7.setStroke(Color.BLACK);
       
       QuadCurve qc8 = new QuadCurve();
       qc8.setStartX(844.0f);
       qc8.setStartY(198.0f);
       qc8.setEndX(865.0f);
       qc8.setEndY(220.0f);
       qc8.setControlX(897.0f);
       qc8.setControlY(180.0f);
       qc8.setFill(Color.TRANSPARENT);
       qc8.setStroke(Color.BLACK);
       
       Ellipse e = new Ellipse();
       e.setCenterX(432.0f);
       e.setCenterY(292.0f);
       e.setRadiusX(32.0f);
       e.setRadiusY(43.0f);
       Ellipse e2 = new Ellipse();
       e2.setCenterX(720.0f);
       e2.setCenterY(298.0f);
       e2.setRadiusX(32.0f);
       e2.setRadiusY(43.0f);
       
       
       Stop[] stops7 = new Stop[] { new Stop(0, Color.web("#F7DC6F")), new Stop(1, Color.web("#FCF3CF")), new Stop(.1, Color.web("#FCF3CF")), new Stop(.2, Color.web("#F4D03F")), new Stop(.4, Color.web("#F7DC6F"))};
       LinearGradient lg17 = new LinearGradient(0, 0, 1, 0, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops7);
       e.setFill(Color.web("#F3C81A"));
       e.setStroke(Color.BLACK);
       e.setStrokeWidth(3);
       
       e2.setFill(Color.web("#F3C81A"));
       e2.setStroke(Color.BLACK);
       e2.setStrokeWidth(3);
       
       Stop[] stops24 = new Stop[] { new Stop(0, Color.web("#A8A89A")), new Stop(1, Color.web("#A4A49A")), new Stop(.1, Color.web("#C8C8BB")), new Stop(.2, Color.web("#D7D7D1")), new Stop(.4, Color.web("#D7D7D1"))};
       LinearGradient lg21 = new LinearGradient(0, 0, 1, 0, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops24);
       
       Ellipse e3 = new Ellipse();
       e3.setCenterX(387.0f);
       e3.setCenterY(110.0f);
       e3.setRadiusX(10.0f);
       e3.setRadiusY(13.0f);
       e3.setFill(lg21);
       e3.setStrokeWidth(2);
       e3.setStroke(Color.GRAY);
       Ellipse e4 = new Ellipse();
       e4.setCenterX(750.0f);
       e4.setCenterY(110.0f);
       e4.setRadiusX(10.0f);
       e4.setRadiusY(13.0f);
       e4.setFill(lg21);
       e4.setStrokeWidth(2);
       e4.setStroke(Color.GRAY);
       
       Rectangle r = new Rectangle();
        r.setX(419);
        r.setY(285);
        r.setWidth(26);
        r.setHeight(17);
        r.setArcWidth(4);
        r.setArcHeight(2);
        
       Rectangle r2 = new Rectangle();
        r2.setX(705);
        r2.setY(289);
        r2.setWidth(26);
        r2.setHeight(17);
        r2.setArcWidth(4);
        r2.setArcHeight(2); 
        
        Rectangle fondo = new Rectangle();
        fondo.setX(0);
        fondo.setY(0);
        fondo.setWidth(1050);
        fondo.setHeight(850); //850,1050
        //fondo.setArcWidth(4);
        //fondo.setArcHeight(2);                    , new Stop(0, Color.web("#4DBEDE"))
        Stop[] stops = new Stop[] { new Stop(0, Color.web("#E1DDDA")), new Stop(1, Color.web("#2092BF")), new Stop(.1, Color.web("#36AEDD")), new Stop(.2, Color.web("#7AB6CE")), new Stop(.4, Color.web("#7AB6CE"))};
        LinearGradient lg1 = new LinearGradient(0, 1, 0, 0, true, javafx.scene.paint.CycleMethod.NO_CYCLE, stops);
        fondo.setFill(Color.web("#65C8D7"));
        
        Arc a = new Arc();
        a.setCenterX(605.0f);
        a.setCenterY(635.0f);
        a.setRadiusX(49.0f);
        a.setRadiusY(68.0f);
        a.setStartAngle(450.0f);
        a.setLength(27.0f);
        a.setFill(Color.TRANSPARENT);
        a.setStroke(Color.BLACK);
        a.setStrokeWidth(5);
        
        Arc a2 = new Arc();
        a2.setCenterX(512.0f);
        a2.setCenterY(602.0f);
        a2.setRadiusX(47.0f);
        a2.setRadiusY(50.0f);
        a2.setStartAngle(387.0f);
        a2.setLength(30.0f);
        a2.setFill(Color.TRANSPARENT);
        a2.setStroke(Color.BLACK); a2.setStrokeWidth(5);
        
       
       ImageView logoh = new ImageView();
       logoh.setImage(new Image("/resources/konoha.png"));
       logoh.setLayoutX(490);
       logoh.setLayoutY(-30);
       logoh.setFitHeight(180);
       logoh.setFitWidth(160);
       
       Button btn = new Button();
       btn.setText("Gradientes");
       btn.setOnAction(new EventHandler<ActionEvent>() {
           @Override
           public void handle(ActionEvent event) {
                cin.setFill(lg15);
                pelo.setFill(lg12);
                cara.setFill(lg16);
                pelo2.setFill(lg13);
                pelo3.setFill(lg14);
                pelo4.setFill(lg13);
                ojo.setFill(Color.web("#FF6C00"));
                ojo2.setFill(lg29);
                ojo3.setFill(Color.web("#FF6C00"));
                ojo4.setFill(lg29);
                e.setFill(lg17);
                e2.setFill(lg17);
                fondo.setFill(lg1);
           }
       });
       
       btn.setLayoutX(20);
       btn.setLayoutY(20);
                                                           
       root.getChildren().addAll(fondo,cin2,cin3,pelo3,pelo2,ropa,ropa2,oreja,cara,l,l2,l3,l4,l5,l6,pelo4,oreja2,qc8,ropa3,ropa4,ropa5,pelo5,ojo,ojo2,ojo3,ojo4,e,e2,r,r2,a,a2,pc2,cin,e4,pelo,qc,qc2,qc3,cejas,cejas2,qc4,qc5,logoh,e3,qc6,qc7,btn); //falta ponerle pelo2,pelo3,pelo5,pelo4,cara ,pc,cin pelo5
       
       Scene scene = new Scene(root, 1000, 838);
       
       primaryStage.setTitle("Proyecto Dibujo");
       primaryStage.setScene(scene);
       primaryStage.setResizable(false);
       primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
}
