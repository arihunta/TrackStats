package arihunta.trackstats

import arihunta.trackstats.ui.MainUi
import javax.swing.UIManager

fun main ( args : Array<String> ) {

	UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

	MainUi().setVisible(true)

}
