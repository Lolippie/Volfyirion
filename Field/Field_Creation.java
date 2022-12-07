// Je revendique ce replit au nom de Volfyrion.
// Gloire à lui! \o/
package Field;// Pour faciliter les choses les ressources sont dans l'ordre coin/attack/wisdom (autant que possible)
import Field.Player.City.*;
import java.util.ArrayList;
import java.util.Arrays;
//import javax.swing.*;
import Using.Card.Protector;
import Using.Card.Normal;
import Using.Card.Building;
import Using.Card.Wonder;
import Using.Card.*;
import Using.Color.*;


public class Field_Creation {
	 private Field field ;
	public Field_Creation(){
		this.field = CreationField();
	}

	public Field CreationField(){
	City city_1 = new City("TYLARIS", 8, "../Uti/img/carte_volfyirion/Villes/Tylaris.jpg");
	City city_2 = new City("VAHYLEA", 9, "../Uti/img/carte_volfyirion/Villes/Vahylea.jpg");
	City city_3 = new City("ALANTAR", 10, "../Uti/img/carte_volfyirion/Villes/Alantar.jpg");
	City city_4 = new City("YRDESH", 8, "../Uti/img/carte_volfyirion/Villes/Yrdesh.jpg");
	City city_5 = new City("AKAO UKET", 9, "../Uti/img/carte_volfyirion/Villes/Akao_uket.jpg");
	City city_6 = new City("KYR",10, "../Uti/img/carte_volfyirion/Villes/Kyr.jpg");
// -------------------------------------------------------------------------------
                                            // STARTER CARD
    	Card prospector_1  = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
    	Card prospector_2  = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_3  = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_4  = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_5  = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_6  = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_7  = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_8  = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_9  = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_10 = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_11 = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_12 = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_13 = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_14 = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_15 = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
		Card prospector_16 = new Normal("Prospector", 0, Normal.ComboNor.none, "null", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/prospector.jpg");
	// Captain
		Card captain_1 = new Normal("Captain", 0, Normal.ComboNor.none, "null", 1, 3, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/captain.jpg");
		Card captain_2 = new Normal("Captain", 0, Normal.ComboNor.none, "null", 1, 3, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/captain.jpg");
	// Diviner
		Card diviner_1 = new Normal("Diviner", 0, Normal.ComboNor.none, "null", 1, 0, 3, Color.grey, "../Uti/img/carte_volfyirion/Normals/diviner.jpg");
		Card diviner_2 = new Normal("Diviner", 0,  Normal.ComboNor.none, "null", 1, 0, 3, Color.grey, "../Uti/img/carte_volfyirion/Normals/diviner.jpg");

  
  // -----------------------------------------------------------------------------
                                                                    //WONDERS
  
  // Tous les effets ont le cout de détruire la carte
	// Sharp Qoam
		Wonder sharp_qoam_1 = new Wonder("Sharp Qoam", 2, "e_bonus_coin_2", 0, 1, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/sharp_qoam.jpg");
		Wonder sharp_qoam_2 = new Wonder("Sharp Qoam", 2, "e_bonus_coin_2", 0, 1, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/sharp_qoam.jpg");
	// Divining Petals
		Wonder divining_petals_1 = new Wonder("Divnining Petals", 2, "e_bonus_wisdom_2", 0, 1, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/divining_petals.jpg");
		Wonder divining_petals_2 = new Wonder("Divnining Petals", 2, "e_bonus_wisdom_2", 0, 1, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/divining_petals.jpg");
	// Ascension Path
		Wonder ascension_path_1 = new Wonder("Ascension Path", 3, "null", 2, 2, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/ascension_path.jpg"); // cout d'achat et de blockage différents
		Wonder ascension_path_2 = new Wonder("Ascension Path", 3, "null", 2, 2, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/ascension_path.jpg");
	// Voracious Seed
		Wonder voracious_seed_1 = new Wonder("Voracious Seed", 3, "e_bat_destroy", 0, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/voracious_seed.jpg");
		Wonder voracious_seed_2 = new Wonder("Voracious Seed", 3, "e_bat_destroy", 0, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/voracious_seed.jpg");
	// Living Knife
		Wonder living_knife_1 = new Wonder("Living Knife", 3, "e_kill_Protector", 0, 1, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/living_knife.jpg");
		Wonder living_knife_2 = new Wonder("Living Knife", 3, "e_kill_Protector", 0, 1, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/living_knife.jpg");
	// Strange Box
		Wonder strange_box_1 = new Wonder("Strange Box", 3, "e_bonus_coin_2", 1, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/strange_box.jpg");
		Wonder strange_box_2 = new Wonder("Strange Box", 3, "e_bonus_coin_2", 1, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/strange_box.jpg");
	// Glowing Fungi
		Wonder glowing_fungi_1 = new Wonder("Glowing Fungi", 3, "e_card_destruct", 1, 1, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/glowing_fungii.jpg");
		Wonder glowing_fungi_2 = new Wonder("Glowing Fungi", 3, "e_card_destruct", 1, 1, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/glowing_fungii.jpg");
	// Pure Qoam
		Wonder pure_qoam_1 = new Wonder("Pure Qoam", 3, "e_bonus_wisdom_3", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/pure_qoam.jpg");
		Wonder pure_qoam_2 = new Wonder("Pure Qoam", 3, "e_bonus_wisdom_3", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/pure_qoam.jpg");
	// Sibilant Crystal
		Wonder sibilant_crystal_1 = new Wonder("Sibilant Crystal", 3, "e_bonus_attack_2", 1, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/sibilant_crystal.jpg");
		Wonder sibilant_crystal_2 = new Wonder("Sibilant Crystal", 3, "e_bonus_attack_2", 1, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/sibilant_crystal.jpg");
	// Black Spores
		Wonder black_spores_1 = new Wonder("Black Spores", 4, "e_kill_Protector", 1, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/black_spores.jpg");
		Wonder black_spores_2 = new Wonder("Black Spores", 4, "e_kill_Protector", 1, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/black_spores.jpg");
	// Primal Beast
		Wonder primal_beast_1 = new Wonder("Primal Beast", 4, "e_card_draw_1", 0, 1, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/primal_beast.jpg");
		Wonder primal_beast_2 = new Wonder("Primal Beast", 4, "e_card_draw_1", 0, 1, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/primal_beast.jpg");
	// Floating Crystal
		Wonder floating_crystal_1 = new Wonder("Floating Crystal", 4, "e_card_draw_1", 1, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/floating_crystal.jpg");
		Wonder floating_crystal_2 = new Wonder("Floating Crystal", 4, "e_card_draw_1", 1, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/floating_crystal.jpg");
	// Void Fluid
		Wonder void_fluid_1 = new Wonder("Void Fluid", 4, "e_bat_destroy", 0, 2, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/void_fluid.jpg");
		Wonder void_fluid_2 = new Wonder("Void Fluid", 4, "e_bat_destroy", 0, 2, 0, Color.grey, "../Uti/img/carte_volfyirion/Wonders/void_fluid.jpg");
	// Emerald horn
		Wonder emerald_horn_1 = new Wonder("Emerald Horn", 6, "e_move_volfyirion", 2, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/emerald_horn.jpg");
		Wonder emerald_horn_2 = new Wonder("Emerald Horn", 6, "e_move_volfyirion", 2, 0, 1, Color.grey, "../Uti/img/carte_volfyirion/Wonders/emerald_horn.jpg");

//----------------------------------------------------------------------------------------------------------------------------------

			Normal barter_1 = new Normal ("Barter", 1, Normal.ComboNor.destruct, "e_bonus_wisdom_3", 1, 0, 0, Color.cyan, "../Uti/img/carte_volfyirion/Normals/barter.jpg");
			Normal barter_2 = new Normal ("Barter", 1, Normal.ComboNor.destruct, "e_bonus_wisdom_3", 1, 0, 0, Color.cyan, "../Uti/img/carte_volfyirion/Normals/barter.jpg");
		// Stab
			Normal stab_1 = new Normal("Stab", 1, Normal.ComboNor.destruct, "e_card_draw_1", 0, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Normals/stab.jpg");
			Normal stab_2 = new Normal("Stab", 1, Normal.ComboNor.destruct, "e_card_draw_1", 0, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Normals/stab.jpg");
		// Qoam Ritual
			Normal qoam_ritual_1 = new Normal("Qoam Ritual", 1, Normal.ComboNor.destruct, "e_card_destruct", 1, 0, 0, Color.magenta, "../Uti/img/carte_volfyirion/Normals/qoam_ritual.jpg");
			Normal qoam_ritual_2 = new Normal("Qoam Ritual", 1, Normal.ComboNor.destruct, "e_card_destruct", 1, 0, 0, Color.magenta, "../Uti/img/carte_volfyirion/Normals/qoam_ritual.jpg");
		// Worthy Trade
			Normal worthy_trade_1 = new Normal("Worthy Trade", 2, Normal.ComboNor.destruct, "e_card_destruct", 1, 0, 1, Color.cyan, "../Uti/img/carte_volfyirion/Normals/worthy_trade.jpg");
			Normal worthy_trade_2 = new Normal("Worthy Trade", 2, Normal.ComboNor.destruct, "e_card_destruct", 1, 0, 1, Color.cyan, "../Uti/img/carte_volfyirion/Normals/worthy_trade.jpg");
		// Hidden Cache
			Normal hidden_cache_1 = new Normal("Hidden Cache", 2, Normal.ComboNor.magenta, "e_bonus_attack_2", 0, 0, 2, Color.magenta, "../Uti/img/carte_volfyirion/Normals/hidden_cache.jpg");
			Normal hidden_cache_2 = new Normal("Hidden Cache", 2, Normal.ComboNor.magenta, "e_bonus_attack_2", 0, 0, 2, Color.magenta, "../Uti/img/carte_volfyirion/Normals/hidden_cache.jpg");
		// Saboteur
			Normal saboteur_1 = new Normal("Saboteur", 3, Normal.ComboNor.saboteur, "e_saboteur", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/saboteur.jpg");
			Normal saboteur_2 = new Normal("Saboteur", 3, Normal.ComboNor.saboteur, "e_saboteur", 1, 0, 0, Color.grey, "../Uti/img/carte_volfyirion/Normals/saboteur.jpg");
		// Telron's Analysis
			Normal telrons_analysis_1 = new Normal("Telron's Analysis", 3, Normal.ComboNor.cyan, "e_card_draw_1", 2, 0, 1, Color.cyan, "../Uti/img/carte_volfyirion/Normals/telron_analysis.jpg");
			Normal telrons_analysis_2 = new Normal("Telron's Analysis", 3, Normal.ComboNor.cyan, "e_card_draw_1", 2, 0, 1, Color.cyan, "../Uti/img/carte_volfyirion/Normals/telron_analysis.jpg");
		// Decisive Strike
			Normal decisive_strike_1 = new Normal("Decisive Strike", 3, Normal.ComboNor.red, "e_bonus_attack_2", 0, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Normals/decisive_strike.jpg");
			Normal decisive_strike_2 = new Normal("Decisive Strike", 3, Normal.ComboNor.red, "e_bonus_attack_2", 0, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Normals/decisive_strike.jpg");
		// Suicide Mission
			Normal suicide_mission_1 = new Normal("Suicide Mission", 3, Normal.ComboNor.destruct, "e_bat_destroy", 0, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Normals/suicide_mission.jpg");
			Normal suicide_mission_2 = new Normal("Suicide Mission", 3, Normal.ComboNor.destruct, "e_bat_destroy", 0, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Normals/suicide_mission.jpg");
		// Celethe's Law
			Normal celethes_law_1 = new Normal("Celethes Law", 3, Normal.ComboNor.magenta, "e_card_destruct", 2, 0, 2, Color.magenta, "../Uti/img/carte_volfyirion/Normals/celethe_law.jpg");
			Normal celethes_law_2 = new Normal("Celethes Law", 3, Normal.ComboNor.magenta, "e_card_destruct", 2, 0, 2, Color.magenta, "../Uti/img/carte_volfyirion/Normals/celethe_law.jpg");;
		// Harness Qoam
			Normal harness_qoam_1 = new Normal("Harness Qoam", 4, Normal.ComboNor.cyan_red, "e_bonus_attack_2_wisdom_2", 2, 1, 1, Color.cyan, "../Uti/img/carte_volfyirion/Normals/harness_qoam.jpg");
			Normal harness_qoam_2 = new Normal("Harness Qoam", 4, Normal.ComboNor.cyan_red, "e_bonus_attack_2_wisdom_2", 2, 1, 1, Color.cyan, "../Uti/img/carte_volfyirion/Normals/harness_qoam.jpg");
		// Anuth's Trick
			Normal anuths_trick_1 = new Normal("Anuth's Trick", 4, Normal.ComboNor.destruct, "e_kill_Protector", 2, 1, 0, Color.red, "../Uti/img/carte_volfyirion/Normals/anuth_trick.jpg");
			Normal anuths_trick_2 = new Normal("Anuth's Trick", 4, Normal.ComboNor.destruct, "e_kill_Protector", 2, 1, 0, Color.red, "../Uti/img/carte_volfyirion/Normals/anuth_trick.jpg");
		// Feasible Solution
			Normal feasible_solution_1 = new Normal("Feasible Solution", 4, Normal.ComboNor.red_magenta, "e_bonus_coin_2_wisdom_3", 1, 1, 2, Color.magenta, "../Uti/img/carte_volfyirion/Normals/feasible_solution.jpg");
			Normal feasible_solution_2 = new Normal("Feasible Solution", 4, Normal.ComboNor.red_magenta, "e_bonus_coin_2_wisdom_3", 1, 1, 2, Color.magenta, "../Uti/img/carte_volfyirion/Normals/feasible_solution.jpg");
		// Shrewd Deal
			Normal shrewd_deal_1 = new Normal("Shrewd Deal", 5, Normal.ComboNor.cyan, "e_bonus_wisdom_2", 2, 1, 1, Color.cyan, "../Uti/img/carte_volfyirion/Normals/shrewd_deal.jpg");
			Normal shrewd_deal_2 = new Normal("Shrewd Deal", 5, Normal.ComboNor.cyan, "e_bonus_wisdom_2", 2, 1, 1, Color.cyan, "../Uti/img/carte_volfyirion/Normals/shrewd_deal.jpg");
		// Sabotage
			Normal sabotage_1 = new Normal("sabotage", 5, Normal.ComboNor.saboteur, "e_bat_destroy", 2, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Normals/sabotage.jpg");
			Normal sabotage_2 = new Normal("sabotage", 5, Normal.ComboNor.saboteur, "e_bat_destroy", 2, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Normals/sabotage.jpg");
		// Strategic Attack
			Normal strategic_attack_1 = new Normal("Strategic Attack", 5, Normal.ComboNor.red, "e_card_draw_1", 1, 3, 0, Color.magenta, "../Uti/img/carte_volfyirion/Normals/strategic_attack.jpg");
			Normal strategic_attack_2 = new Normal("Strategic Attack", 5, Normal.ComboNor.red, "e_card_draw_1", 1, 3, 0, Color.magenta, "../Uti/img/carte_volfyirion/Normals/strategic_attack.jpg");
		// Qoam Vein
			Normal qoam_vein_1 = new Normal("Qoam Vein", 7, Normal.ComboNor.red_magenta, "e_card_draw_2", 3, 2, 2, Color.cyan, "../Uti/img/carte_volfyirion/Normals/qoam_vein.jpg");
		// Flawless Deploy
			Normal flawless_deploy_1 = new Normal("Flawless Deploy", 7, Normal.ComboNor.cyan_magenta, "e_card_draw_2", 2, 3, 2, Color.red, "../Uti/img/carte_volfyirion/Normals/flawless_deploy.jpg");
		// Alchemic Key
			Normal alchemic_key_1 = new Normal("Alchemic Key", 7, Normal.ComboNor.cyan, "e_card_draw_1", 2, 2, 3, Color.magenta, "../Uti/img/carte_volfyirion/Normals/Alchemic_key.jpg");
		// Volfyirion's Mark
			Normal volfyirions_mark_1 = new Normal("Volfyirion's Mark", 8, Normal.ComboNor.cyan_magenta, "e_move_volfyirion", 3, 3, 2, Color.cyan, "../Uti/img/carte_volfyirion/Normals/volfyirion_mark.jpg");
		// Endless Tactic
			Normal endless_tactic_1 = new Normal("Endless Tactic", 8, Normal.ComboNor.cyan_magenta, "e_bonus_attack_3", 2, 4, 3, Color.red, "../Uti/img/carte_volfyirion/Normals/endless_tactic.jpg");
		// Book of wisdom
			Normal book_of_wisdom_1 = new Normal("Book of Wisdom", 8, Normal.ComboNor.red_red, "e_card_draw_2", 2, 1, 5, Color.magenta, "../Uti/img/carte_volfyirion/Normals/book_of_wisdom.jpg");


// -------------------------------------------------------------------------------------------------------
                                          // Buildings
// Mint
			Building mint_1 = new Building("Mint", 4, Building.ComboBui.cyan_cyan, "e_bonus_coin_2", 1, 0, 1, Color.cyan, "../Uti/img/carte_volfyirion/Buildings/mint.jpg");
		// Barracks
			Building barracks_1 = new Building("Barracks", 4, Building.ComboBui.red_red, "e_card_draw_1", 0, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Buildings/barracks.jpg");
		// Apothecary
		Building apothecary_1 = new Building("Apothecary", 4, Building.ComboBui.cyan, "e_bonus_wisdom_1", 1, 0, 1, Color.magenta, "../Uti/img/carte_volfyirion/Buildings/apothecary.jpg");
			Building apothecary_2 = new Building("Apothecary", 4, Building.ComboBui.cyan, "e_bonus_wisdom_1", 1, 0, 1, Color.magenta, "../Uti/img/carte_volfyirion/Buildings/apothecary.jpg");
		// Black Market
			Building black_market_1 = new Building("Black Market", 5, Building.ComboBui.red, "e_card_destruct", 2, 0, 0, Color.cyan, "../Uti/img/carte_volfyirion/Buildings/black_market.jpg");
			Building black_market_2 = new Building("Black Market", 5, Building.ComboBui.red, "e_card_destruct", 2, 0, 0, Color.cyan, "../Uti/img/carte_volfyirion/Buildings/black_market.jpg");
		// War Academy
			Building war_academy_1 = new Building("War Academy", 5, Building.ComboBui.red_magenta, "e_bonus_attack_2", 0, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Buildings/war_academy.jpg");
			Building war_academy_2 = new Building("War Academy", 5, Building.ComboBui.red_magenta, "e_bonus_attack_2", 0, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Buildings/war_academy.jpg");
		// Library
			Building library_1 = new Building("Library", 5, Building.ComboBui.cyan_magenta, "e_card_draw_1", 2, 0, 0, Color.magenta, "../Uti/img/carte_volfyirion/Buildings/library.jpg");
			Building library_2 = new Building("Library", 5, Building.ComboBui.cyan_magenta, "e_card_draw_1", 2, 0, 0, Color.magenta, "../Uti/img/carte_volfyirion/Buildings/library.jpg");
		// Bank
			Building bank_1 = new Building("Bank", 6, Building.ComboBui.cyan, "e_card_draw_1", 1, 1, 0, Color.cyan, "../Uti/img/carte_volfyirion/Buildings/bank.jpg");
		// Headquarters
			Building headquarters_1 = new Building("Headquarters", 6, Building.ComboBui.cyan_red, "e_bonus_coin_1_wisdom_2", 1, 2, 0, Color.red, "../Uti/img/carte_volfyirion/Buildings/headquarters.jpg");
		// Laboratory
			Building laboratory_1 = new Building("Laboratory", 6, Building.ComboBui.red, "e_bonus_attack_1", 1, 1, 1, Color.magenta, "../Uti/img/carte_volfyirion/Buildings/laboratory.jpg");


// -------------------------------------------------------------------------------------------------------
                                                    // Protector
  // Mercenary Archer
			Protector mercenary_archer_1 = new Protector("Mercenary Archer", 2, "e_mercenary", 4, Color.grey, "../Uti/img/carte_volfyirion/Protectors/mercenary_archer.jpg");
			Protector mercenary_archer_2 = new Protector("Mercenary Archer", 2, "e_mercenary", 4, Color.grey, "../Uti/img/carte_volfyirion/Protectors/mercenary_archer.jpg");
		// Soldier
			Protector soldier_1 = new Protector("Soldier", 3, "e_bonus_attack_2", 3, Color.grey, "../Uti/img/carte_volfyirion/Protectors/soldier.jpg");
			Protector soldier_2 = new Protector("Soldier", 3, "e_bonus_attack_2", 3, Color.grey, "../Uti/img/carte_volfyirion/Protectors/soldier.jpg");
		//Fighter
			Protector fighter_1 = new Protector("Fighter", 3, "e_bonus_attack_3", 2, Color.grey, "../Uti/img/carte_volfyirion/Protectors/fighter.jpg");
			Protector fighter_2 = new Protector("Fighter", 3, "e_bonus_attack_3", 2, Color.grey, "../Uti/img/carte_volfyirion/Protectors/fighter.jpg");
		// Novice
			Protector novice_1 = new Protector("Novice", 3, "e_bonus_wisdom_3", 2, Color.grey, "../Uti/img/carte_volfyirion/Protectors/novice.jpg");
			Protector novice_2 = new Protector("Novice", 3, "e_bonus_wisdom_3", 2, Color.grey, "../Uti/img/carte_volfyirion/Protectors/novice.jpg");
		// Mercenary Veteran
			Protector mercenary_veteran_1 = new Protector("Mercenary Veteran", 3, "e_mercenary", 5, Color.grey, "../Uti/img/carte_volfyirion/Protectors/mercenary_veteran.jpg");
			Protector mercenary_veteran_2 = new Protector("Mercenary Veteran", 3, "e_mercenary", 5, Color.grey, "../Uti/img/carte_volfyirion/Protectors/mercenary_veteran.jpg");
		// Guard
			Protector guard_1 = new Protector("Guard", 4, "e_bonus_attack_3", 4, Color.grey, "../Uti/img/carte_volfyirion/Protectors/guard.jpg");
			Protector guard_2 = new Protector("Guard", 4, "e_bonus_attack_3", 4, Color.grey,"../Uti/img/carte_volfyirion/Protectors/guard.jpg");
		// Qoam Scout
			Protector qoam_scout_1 = new Protector("Qoam Scout", 4, "e_bonus_wisdom_3", 3, Color.cyan, "../Uti/img/carte_volfyirion/Protectors/qoam_scout.jpg");
			Protector qoam_scout_2 = new Protector("Qoam Scout", 4, "e_bonus_wisdom_3", 3, Color.cyan, "../Uti/img/carte_volfyirion/Protectors/qoam_scout.jpg");
		// Scholar
			Protector scholar_1 = new Protector("Scholar", 4, "e_bonus_wisdom_3", 3, Color.magenta, "../Uti/img/carte_volfyirion/Protectors/scholar.jpg");
			Protector scholar_2 = new Protector("Scholar", 4, "e_bonus_wisdom_3", 3, Color.magenta, "../Uti/img/carte_volfyirion/Protectors/scholar.jpg");
		// Armored Soldier
			Protector armored_soldier_1 = new Protector("Armored Soldier", 6, "e_bonus_attack_5", 5, Color.cyan, "../Uti/img/carte_volfyirion/Protectors/armored_soldier.jpg");
		// Qoamipulator
			Protector qoamipulator_1 = new Protector("Qoamipulator", 6, "e_bonus_wisdom_5", 5, Color.magenta, "../Uti/img/carte_volfyirion/Protectors/qoamipulator.jpg");
		// Elite Trooper
			Protector elite_trooper_1 = new Protector("Elite Trooper", 7, "e_bonus_attack_5", 6, Color.red, "../Uti/img/carte_volfyirion/Protectors/elite_trooper.jpg");
// ----------------------------------------------------------------------------------------------------------
  
 ArrayList<Wonder> wonders_pile = new ArrayList<Wonder>(Arrays.asList(sharp_qoam_1, sharp_qoam_2, divining_petals_1, divining_petals_2, ascension_path_1, ascension_path_2, voracious_seed_1, voracious_seed_2, living_knife_1, living_knife_2, strange_box_1, strange_box_2, glowing_fungi_1, glowing_fungi_2, pure_qoam_1, pure_qoam_2, sibilant_crystal_1, sibilant_crystal_2, black_spores_1, black_spores_2, primal_beast_1, primal_beast_2, floating_crystal_1, floating_crystal_2, void_fluid_1, void_fluid_2, emerald_horn_1, emerald_horn_2));
  
  ArrayList<Normal> normals = new ArrayList<Normal>(Arrays.asList(barter_1, barter_2, stab_1, stab_2, qoam_ritual_1, qoam_ritual_2, worthy_trade_1, worthy_trade_2, hidden_cache_1, hidden_cache_2, saboteur_1, saboteur_2, telrons_analysis_1, telrons_analysis_2, decisive_strike_1, decisive_strike_2, suicide_mission_1, suicide_mission_2, celethes_law_1, celethes_law_2, harness_qoam_1, harness_qoam_2, anuths_trick_1, anuths_trick_2, feasible_solution_1, feasible_solution_2, shrewd_deal_1, shrewd_deal_2, sabotage_1, sabotage_2, strategic_attack_1, strategic_attack_2, qoam_vein_1, flawless_deploy_1, alchemic_key_1, volfyirions_mark_1, endless_tactic_1, book_of_wisdom_1));

ArrayList<Building> buildings = new ArrayList<Building>(Arrays.asList(mint_1, barracks_1, apothecary_1, apothecary_2, black_market_1, black_market_2, war_academy_1, war_academy_2, library_1, library_2, bank_1, headquarters_1, laboratory_1));

ArrayList<Protector> protectors = new ArrayList<Protector>(Arrays.asList(mercenary_archer_1, mercenary_archer_2,soldier_1, soldier_2, fighter_1, fighter_2, novice_1, novice_2, mercenary_veteran_1, mercenary_veteran_2, guard_1, guard_2, qoam_scout_1, qoam_scout_2, scholar_1, scholar_2, armored_soldier_1, qoamipulator_1, elite_trooper_1));

ArrayList<Card> market_pile = new ArrayList<Card>(Arrays.asList(barter_1, barter_2, stab_1, stab_2, qoam_ritual_1, qoam_ritual_2, worthy_trade_1, worthy_trade_2, hidden_cache_1, hidden_cache_2, saboteur_1, saboteur_2, telrons_analysis_1, telrons_analysis_2, decisive_strike_1, decisive_strike_2, suicide_mission_1, suicide_mission_2, celethes_law_1, celethes_law_2, harness_qoam_1, harness_qoam_2, anuths_trick_1, anuths_trick_2, feasible_solution_1, feasible_solution_2, shrewd_deal_1, shrewd_deal_2, sabotage_1, sabotage_2, strategic_attack_1, strategic_attack_2, qoam_vein_1, flawless_deploy_1, alchemic_key_1, volfyirions_mark_1, endless_tactic_1, book_of_wisdom_1, mint_1, barracks_1, apothecary_1, apothecary_2, black_market_1, black_market_2, war_academy_1, war_academy_2, library_1, library_2, bank_1, headquarters_1, laboratory_1, mercenary_archer_1, mercenary_archer_2,soldier_1, soldier_2, fighter_1, fighter_2, novice_1, novice_2, mercenary_veteran_1, mercenary_veteran_2, guard_1, guard_2, qoam_scout_1, qoam_scout_2, scholar_1, scholar_2, armored_soldier_1, qoamipulator_1, elite_trooper_1));
// --------------------------------------------------------------------------------------
  
  this.field = new Field("Player 1","Player 2", city_1, city_2, city_3, city_4, city_5 ,city_6, market_pile, wonders_pile, protectors, normals, buildings);
  field.getPlayer1().getDeckPlayer().addCardRest(prospector_1);
  field.getPlayer1().getDeckPlayer().addCardRest(prospector_2);
  field.getPlayer1().getDeckPlayer().addCardRest(prospector_3);
  field.getPlayer1().getDeckPlayer().addCardRest(prospector_4);
  field.getPlayer1().getDeckPlayer().addCardRest(prospector_5);
  field.getPlayer1().getDeckPlayer().addCardRest(prospector_6);
  field.getPlayer1().getDeckPlayer().addCardRest(prospector_7);
  field.getPlayer1().getDeckPlayer().addCardRest(prospector_8);
  field.getPlayer2().getDeckPlayer().addCardRest(prospector_9);
  field.getPlayer2().getDeckPlayer().addCardRest(prospector_10);
  field.getPlayer2().getDeckPlayer().addCardRest(prospector_11);
  field.getPlayer2().getDeckPlayer().addCardRest(prospector_12);
  field.getPlayer2().getDeckPlayer().addCardRest(prospector_13);
  field.getPlayer2().getDeckPlayer().addCardRest(prospector_14);
  field.getPlayer2().getDeckPlayer().addCardRest(prospector_15);
  field.getPlayer2().getDeckPlayer().addCardRest(prospector_16);
  field.getPlayer1().getDeckPlayer().addCardRest(captain_1);
  field.getPlayer2().getDeckPlayer().addCardRest(captain_2);
  field.getPlayer1().getDeckPlayer().addCardRest(diviner_1);
  field.getPlayer2().getDeckPlayer().addCardRest(diviner_2);
  field.getPlayer1().getDeckPlayer().addCardRest(mercenary_archer_1);
  field.getPlayer1().getDeckPlayer().addCardRest(mercenary_archer_2);
  field.getPlayer1().getDeckPlayer().addCardRest(soldier_1);
  field.getPlayer1().getDeckPlayer().addCardRest(soldier_2);
  return field;
	}

	public void setField(Field f){
		this.field =f;
	}
	public Field getField(){
		return this.field;
	}
}