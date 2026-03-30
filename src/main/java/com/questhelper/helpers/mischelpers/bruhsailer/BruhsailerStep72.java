package com.questhelper.helpers.mischelpers.bruhsailer;

import com.questhelper.collections.ItemCollections;
import com.questhelper.panel.PanelDetails;
import com.questhelper.questinfo.QuestHelperQuest;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.requirements.quest.QuestRequirement;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.ObjectStep;
import com.questhelper.steps.QuestStep;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.QuestState;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.ObjectID;

public class BruhsailerStep72
{
	private final BruhsailerGuide guide;

	// Requirements
	private ItemRequirement coins;
	private ItemRequirement chronicle;
	private ItemRequirement barleySeeds;
	private ItemRequirement seedDibber;
	private ItemRequirement rake;
	private ItemRequirement compost;
	private ItemRequirement food;
	private ItemRequirement combatGear;

	// Steps
	private DetailedQuestStep bankAndGrab;
	private DetailedQuestStep useChronicle;
	private DetailedQuestStep plantBarley;
	private DetailedQuestStep travelToGrandTree;
	private DetailedQuestStep continueGrandTree;
	private DetailedQuestStep enterShipyard;
	private NpcStep buyFromGnomeWaiter;
	private NpcStep charterToPortSarim;
	private NpcStep talkToVeos;
	private DetailedQuestStep arriveKourend;

	public BruhsailerStep72(BruhsailerGuide guide)
	{
		this.guide = guide;
	}

	public void setup()
	{
		setupRequirements();
		setupSteps();
	}

	private void setupRequirements()
	{
		coins = new ItemRequirement("Coins", ItemID.COINS, 3000);
		coins.setTooltip("For charter ships, Gnome Waiter purchases, and other costs");
		chronicle = new ItemRequirement("Chronicle", ItemID.CHRONICLE);
		chronicle.setTooltip("Teleport near Champions' Guild");
		barleySeeds = new ItemRequirement("Barley seeds", ItemID.BARLEY_SEED, 4);
		seedDibber = new ItemRequirement("Seed dibber", ItemID.DIBBER);
		rake = new ItemRequirement("Rake", ItemID.RAKE);
		compost = new ItemRequirement("Compost", ItemID.BUCKET_SUPERCOMPOST);
		compost.addAlternates(ItemID.BUCKET_ULTRACOMPOST);
		compost.setTooltip("Supercompost or ultracompost");
		food = new ItemRequirement("Food", ItemCollections.GOOD_EATING_FOOD, -1);
		food.setTooltip("For combat during The Grand Tree");
		combatGear = new ItemRequirement("Combat gear", -1, -1);
		combatGear.setTooltip("Weapon and armour for The Grand Tree boss fight");
	}

	private void setupSteps()
	{
		bankAndGrab = new DetailedQuestStep(guide,
			"Bank and grab items for this step: chronicle, barley seeds, seed dibber, rake, " +
			"compost, coins (~3k for charters), food and combat gear for The Grand Tree.",
			coins, chronicle, barleySeeds, seedDibber, rake, compost, food);

		useChronicle = new DetailedQuestStep(guide, new WorldPoint(3190, 3366, 0),
			"Use your Chronicle to teleport near the Champions' Guild.", chronicle);

		plantBarley = new DetailedQuestStep(guide, new WorldPoint(3231, 3314, 0),
			"Plant barley seeds at the hops patch south-east of the Champions' Guild. " +
			"Rake any weeds, apply compost, then plant your barley seeds.",
			barleySeeds, seedDibber, rake, compost);

		travelToGrandTree = new DetailedQuestStep(guide, new WorldPoint(2466, 3495, 0),
			"Travel to the Tree Gnome Stronghold and the Grand Tree. Use the Spirit tree " +
			"or other teleport methods available to you.");

		continueGrandTree = new DetailedQuestStep(guide, new WorldPoint(2466, 3495, 0),
			"Continue The Grand Tree quest. Progress through the quest until you reach the " +
			"Karamja Shipyard checkpoint. Select 'The Grand Tree' in Quest Helper for " +
			"detailed steps. Make sure you have combat gear for the Black Demon fight.",
			food);
		continueGrandTree.conditionToFadeInSidebar(new QuestRequirement(QuestHelperQuest.THE_GRAND_TREE, QuestState.FINISHED));

		enterShipyard = new DetailedQuestStep(guide, new WorldPoint(2987, 3032, 0),
			"Enter the Karamja Shipyard. When asked for the password, use the dialog options: " +
			"'Glough sent me.' -> 'Ka.' -> 'Lu.' -> 'Min.'");

		buyFromGnomeWaiter = new NpcStep(guide, NpcID.BLURBERRY,
			new WorldPoint(2482, 3491, 1),
			"Buy 4 gnome food items from the Gnome Waiter/Blurberry on the 1st floor of the Grand Tree. " +
			"Get: 1 Chocolate bomb, 1 Tangled toads' legs, 1 Worm hole, 1 Blurberry special. " +
			"These are needed for various quests later.", coins);

		charterToPortSarim = new NpcStep(guide, NpcID.SAILING_TRANSPORT_TRADER_STAN_CREW_WOMAN1_BRIMHAVEN,
			new WorldPoint(3001, 3032, 0),
			"Charter a ship from the Karamja Shipyard (or nearby port) towards Port Sarim. " +
			"This will cost coins.", coins);

		talkToVeos = new NpcStep(guide, NpcID.VEOS_VISIBLE,
			new WorldPoint(3228, 3242, 0),
			"Talk to Veos at Port Sarim docks to travel to Great Kourend. " +
			"He is located on the most south-eastern dock.", coins);

		arriveKourend = new DetailedQuestStep(guide, new WorldPoint(1515, 3405, 0),
			"Arrive at Kourend. Once in Port Piscarilius, make your way to Land's End " +
			"if needed, or proceed directly to your next destination in Kourend.");
	}

	public QuestStep getFirstStep()
	{
		return bankAndGrab;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(coins, chronicle, barleySeeds, seedDibber, rake, compost, food);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 72: Chronicle, Grand Tree & Kourend Travel",
			Arrays.asList(bankAndGrab, useChronicle, plantBarley, travelToGrandTree,
				continueGrandTree, enterShipyard, buyFromGnomeWaiter, charterToPortSarim,
				talkToVeos, arriveKourend),
			coins, chronicle, barleySeeds, seedDibber, rake, compost, food);
	}
}
