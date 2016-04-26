package com.ecomlogix.ecom.core;

import java.util.Arrays;
import java.util.HashSet;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.annotation.Commit;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ecomlogix.ecom.core.config.RootContextConfiguration;
import com.ecomlogix.ecom.core.product.domain.Item;
import com.ecomlogix.ecom.core.product.domain.Review;
import com.ecomlogix.ecom.core.product.domain.Tag;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = RootContextConfiguration.class)
@Commit
public class BaseIntegrationTestCase {

   Logger        logger = LoggerFactory.getLogger(BaseIntegrationTestCase.class);

   @PersistenceContext
   EntityManager entityManager;

   @Test
   @Transactional
   public void testSave() {

      //
      // Create 5 tags
      //

      Tag xPhone = new Tag("Orange", "xPhone", null);
      Tag xTablet = new Tag("Orange", "xTablet", null);
      Tag solarSystem = new Tag("Song-Sung", "Solar System Phone", null);
      Tag flame = new Tag("Jungle", "Flame Book Reader", null);
      Tag pc = new Tag("Lenovo", "Personal Computer", null);

      //
      // Create and persist 12 items with tags and customer reviews
      //
      Item theCloud = new Item("The Cloud", "cloud.jpg",
         "The Cloud is a place of magic and wonder.  Businesses run smoothly in the Cloud.  Developers no longer need system administrators, or food and water for that matter.  You can watch television on your tablet device from the comfort of your own sofa, without having to look up at the television.  Download the Cloud app, from the Cloud, and harness this awesome power today!",
         "Business", 7.99f);
      theCloud.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { xPhone, xTablet })));
      Review theCloudReview1 = new Review("fanboy1984", 5, "This app makes my xPhone even more stylish and trendy!");
      Review theCloudReview2 = new Review("anti.hipster", 1,
         "I don't understand what 'The Cloud' means.  This seems like more of a catchphrase than a new technology or app...");
      theCloudReview1.setItem(theCloud);
      theCloudReview2.setItem(theCloud);
      
      entityManager.persist(theCloud);
      entityManager.persist(theCloudReview1);
      entityManager.persist(theCloudReview2);
      logger.info("Persisting " + theCloud.getName());

      Item salesCloser = new Item("Sales Closer", "pointing.jpg",
         "A high-powered productivity app for high-powered sales professionals.  Track your high-powered leads, and manage your high-powered schedule.  When you are out on the town doing high-powered networking, you want to show your high-powered sales prospects that you are high-powered too.",
         "Business", 5.99f);
      salesCloser.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { xPhone, solarSystem })));
      Review salesCloserReview = new Review("ShowMeTheMoney", 5,
         "Great app!  If you have used 'Sales Commander 2000' before, then this interface will feel familiar.");
      salesCloserReview.setItem(salesCloser);
      entityManager.persist(salesCloser);
      entityManager.persist(salesCloserReview);
      logger.info("Persisting " + salesCloser.getName());

      Item football = new Item("World Tournament Football", "ball.jpg",
         "This game app offers all the excitement of football (soccer), except that it's played on a touch screen rather than your feet.  So there isn't any of the kicking, or the running, or any of the physical exercise at all.  Other than that, it's pretty much the same.",
         "Games", 1.99f);
      football.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { xTablet, flame })));
      Review footballReview = new Review("RealAmerican", 2, "False advertising... I though this was supposed to be football, but it's a SOCCER game instead.");
      footballReview.setItem(football);
      
      entityManager.persist(football);
      entityManager.persist(footballReview);
      logger.info("Persisting " + football.getName());

      Item crystal = new Item("Yet Another Crystal Game", "brilliant.jpg",
         "A dazzling game app, in which you connect crystals of the same color to make them go away.  It's sort of like Tetris.  Actually, it's sort of like the other dozen or so other games today where you connect crystals of the same color.",
         "Games", 0.99f);
      crystal.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { flame, pc })));
      Review crystalReview = new Review("YetAnotherGamer", 3,
         "Why is this only supported on two devices?  The other dozen clones of this game are available on all devices.  You should really make this app inactive until more devices are supported...");
      crystal.setActive(false);
      crystalReview.setItem(crystal);
      
      entityManager.persist(crystal);
      entityManager.persist(crystalReview);

      logger.info("Persisting " + crystal.getName());

      Item pencilSharpener = new Item("Pencil Sharpener", "pencil.jpg",
         "Sharpen your pencils, by sticking them into your phone's Bluetooth plug and pushing a button.  This app really pushes your phone's hardware to its limits!",
         "Business", 2.99f);
      pencilSharpener.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { xPhone, solarSystem })));
      Review pencilSharpenerReview1 = new Review("missing.digits", 1, "Ouch, this app is a menace!  I should sue.");
      Review pencilSharpenerReview2 = new Review("LawyerGuy", 5, "@missing.digits:  Private message me.  Let's talk...");
      
      pencilSharpenerReview1.setItem(pencilSharpener);
      pencilSharpenerReview2.setItem(pencilSharpener);
      
      entityManager.persist(pencilSharpener);
      entityManager.persist(pencilSharpenerReview1);
      entityManager.persist(pencilSharpenerReview2);

      logger.info("Persisting " + pencilSharpener.getName());

      Item staplerTracker = new Item("Stapler Tracker", "stapler.jpg",
         "Is someone always taking your stapler?  It's a common problem in many office spaces.  This business productivity app will help you manage your stapler at all times, so that you will never have to deal with a \"case of the Mondays\" again.",
         "Business", 0.99f);
      staplerTracker.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { pc })));
      Review staplerTrackerReview = new Review("mike.bolton", 3, "'PC LOAD LETTER'?  What does that mean?!?");
      entityManager.persist(staplerTracker);
      staplerTrackerReview.setItem(staplerTracker);
      entityManager.persist(staplerTrackerReview);
      logger.info("Persisting " + staplerTracker.getName());

      Item frustratedFlamingos = new Item("Frustrated Flamingos", "flamingo.jpg",
         "A fun little game app, where you throw large birds around for no apparent reason.  Why else do you think they're so frustrated?", "Games", 0.99f);
      frustratedFlamingos.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { xPhone, xTablet, solarSystem, flame, pc })));
      Review frustratedFlamingosReview = new Review("BirdSlinger", 4,
         "LOL, I love catapulting the flamingos into the cows!  I hate how the advertisement banner hides part of the view, tho.");
      frustratedFlamingosReview.setItem(frustratedFlamingos);
      
      entityManager.persist(frustratedFlamingos);
      entityManager.persist(frustratedFlamingosReview);
      logger.info("Persisting " + frustratedFlamingos.getName());

      Item grype = new Item("Grype Video Conferencing", "laptop.jpg",
         "Make free local and international calls, with video, using this app and your home Internet connection.  Better yet, make free calls using your employer's Internet connection!",
         "Internet", 3.99f);
      grype.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { xPhone, xTablet, solarSystem, pc })));
      Review grypeReview = new Review("office.casual", 4,
         "I wish they had not added video to this app in the latest version.  I liked it much more back when I didn't have to get dressed.");
      grypeReview.setItem(grype);
      
      entityManager.persist(grype);
      entityManager.persist(grypeReview);

      logger.info("Persisting " + grype.getName());

      Item eReader = new Item("E-Book Reader", "book.jpg",
         "Read books on your computer, or on the go from your mobile device with this powerful e-reader app.  We recommend \"Hibernate Search by Example\", from Packt Publishing.",
         "Media", 1.99f);
      eReader.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { xPhone, xTablet, solarSystem, flame, pc })));
      Review eReaderReview = new Review("StevePerkins", 5, "This 'Hibernate Search by Example' book is brilliant!  Thanks for the recommendation!");
      eReaderReview.setItem(eReader);

      entityManager.persist(eReader);
      entityManager.persist(eReaderReview);

      logger.info("Persisting " + eReader.getName());

      Item domeBrowser = new Item("Dome Web Browser", "orangeswirls.jpg",
         "This amazing app allows us to track all of your online activity.  We can figure out where you live, what you had for breakfast this morning, or what your closest secrets are.  The app also includes a web browser.",
         "Internet", 0);
      domeBrowser.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { solarSystem, flame, pc })));
      Review domeBrowserReview = new Review("TinFoilHat", 1,
         "I uninstalled this app.  If the government would fake a moon landing, then they would definately use my browser history to come after me.");

      domeBrowserReview.setItem(domeBrowser);

      entityManager.persist(domeBrowser);
      entityManager.persist(domeBrowserReview);

      logger.info("Persisting " + domeBrowser.getName());

      Item athenaRadio = new Item("Athena Internet Radio", "jamming.jpg",
         "Listen to your favorite songs on streaming Internet radio!  When you like a song, this app will play more songs similar to that one.  Or at least it plays more songs... to be honest, sometimes they're not all that similar.  :(",
         "Media", 3.99f);
      athenaRadio.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { xPhone, xTablet, solarSystem, flame, pc })));
      Review athenaRadioReview = new Review("lskinner", 5, "I requested 'Free Bird', and this app played 'Free Bird'.  What's not to like?");

      athenaRadioReview.setItem(athenaRadio);

      entityManager.persist(athenaRadio);
      entityManager.persist(athenaRadioReview);

      logger.info("Persisting " + athenaRadio.getName());

      Item mapJourney = new Item("Map Journey", "compass.jpg",
         "Do you need directions to help you reach a destination?  This GPS app will definitely produce enough turn-by-turn directions to get you there!  Eventually.",
         "Travel", 0.99f);
      mapJourney.setTags(new HashSet<Tag>(Arrays.asList(new Tag[] { xPhone, solarSystem, pc })));
      Review mapJourneyReview = new Review("LostInSpace", 3, "Not great... but still WAY better than Orange maps.");

      mapJourneyReview.setItem(mapJourney);

      entityManager.persist(mapJourney);
      entityManager.persist(mapJourneyReview);
      logger.info("Persisting " + mapJourney.getName());
   }
}