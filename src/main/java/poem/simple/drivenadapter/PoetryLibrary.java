package poem.simple.drivenadapter;

import poem.hexagon.boundary.drivenport.IObtainPoems;

/**
 * Right-side, driven adapter that acts as repository for poems.
 * 
 * Inspired by a talk by A. Cockburn and T. Pierrain on hexagonal architecture:
 * https://www.youtube.com/watch?v=th4AgBcrEHA
 * 
 * @author b_muth
 * 
 */
public class PoetryLibrary implements IObtainPoems {
	public String[] getMePoems(String language) {
		if ("de".equals(language)) {
			return new String[] {
					"DER PANTHER\nIM JARDIN DES PLANTES, PARIS\n\nSein Blick ist vom Vor\u00fcbergehn der St\u00e4be\nso m\u00fcd geworden, dass er nichts mehr h\u00e4lt.\nIhm ist, als ob es tausend St\u00e4be g\u00e4be\nund hinter tausend St\u00e4ben keine Welt.\n\nDer weiche Gang geschmeidig starker Schritte,\nder sich im allerkleinsten Kreise dreht,\nist wie ein Tanz von Kraft um eine Mitte,\nin der bet\u00e4ubt ein groﬂer Wille steht.\n\nNur manchmal schiebt der Vorhang der Pupille\nsich lautlos auf ñ. Dann geht ein Bild hinein,\ngeht durch der Glieder angespannte Stille ñ\nund h\u00f6rt im Herzen auf zu sein.\n\n\n--'Der Panther' von Rainer Maria Rilke",
					"Ich sitze am Straﬂenrand\nDer Fahrer wechselt das Rad.\nIch bin nicht gern, wo ich herkomme.\nIch bin nicht gern, wo ich hinfahre.\nWarum sehe ich den Radwechsel\nMit Ungeduld?\n\n\n--'Der Radwechsel' von Bertold Brecht" };

		} else { 
			return new String[] {
					"I'm nobody! Who are you?\nAre you nobody, too?\nThen there's a pair of us -- don't tell!\nThey'd advertise -- you know!\n\nHow dreary to be somebody!\nHow public like a frog\nTo tell one's name the livelong day\nTo an admiring bog!\n\n--'Im nobody! Who are you?' by Emily Dickinson",
					"Tyger! Tyger! burning bright\nIn the forests of the night,\nWhat immortal hand or eye,\nCould frame thy fearful symmetry?\n\nIn what distant deeps or skies\nBurnt the fire of thine eyes?\nOn what wings dare he aspire?\nWhat the hand dare seize the fire?\n\n-- 'The Tyger' by William Blake",
					"From childhood's hour I have not been\nAs others were ó I have not seen\nAs others saw ó I could not bring\nMy passions from a common spring ó\nFrom the same source I have not taken\nMy sorrow ó I could not awaken\nMy heart to joy at the same tone ó\nAnd all I lov'd ó I lov'd alone ó\nThen ó in my childhood ó in the dawn\nOf a most stormy life ó was drawn\nFrom ev'ry depth of good and ill\nThe mystery which binds me still ó\nFrom the torrent, or the fountain ó\nFrom the red cliff of the mountain ó\nFrom the sun that 'round me roll'd\nIn its autumn tint of gold ó\nFrom the lightning in the sky\nAs it pass'd me flying by ó\nFrom the thunder, and the storm ó\nAnd the cloud that took the form\n(When the rest of Heaven was blue)\nOf a demon in my view ó \n\n--'Alone' by Edgar Allan Poe" };

		}
	}
}