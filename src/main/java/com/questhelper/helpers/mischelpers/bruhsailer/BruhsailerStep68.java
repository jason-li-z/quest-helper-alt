package com.questhelper.helpers.mischelpers.bruhsailer;

import com.questhelper.collections.ItemCollections;
import com.questhelper.panel.PanelDetails;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.steps.DetailedQuestStep;
import com.questhelper.steps.NpcStep;
import com.questhelper.steps.ObjectStep;
import com.questhelper.steps.QuestStep;
import java.util.Arrays;
import java.util.List;
import net.runelite.api.coords.WorldPoint;
import net.runelite.api.gameval.ItemID;
import net.runelite.api.gameval.NpcID;
import net.runelite.api.gameval.ObjectID;

public class BruhsailerStep68
{
	private final BruhsailerGuide guide;

	private ItemRequirement coins;
	private ItemRequirement bucket;
	private ItemRequirement waterRunes;
	private ItemRequirement airStaff;
	private ItemRequirement lawRunes;
	private ItemRequirement runePickaxe;
	private ItemRequirement brownApron;
	private ItemRequirement mazeKey;
	private ItemRequirement airRunes;
	private ItemRequirement mindRunes;
	private ItemRequirement runeSword;
	private ItemRequirement food;
	private ItemRequirement secateurs;
	private ItemRequirement symptomsList;
	private ItemRequirement draynorSkull;
	private ItemRequirement ghostspeak;
	private ItemRequirement cowhides;

	private DetailedQuestStep teleportToFalador;
	private NpcStep getHaircut;
	private ObjectStep fillBucketAtPump;
	private ObjectStep climbFaladorWall;
	private NpcStep talkToZandar;
	private NpcStep talkToMortifer;
	private DetailedQuestStep doCraftingGuildDiaryStops;
	private ObjectStep enterMelzarsMaze;
	private DetailedQuestStep collectFairytaleItems;
	private ObjectStep enterNatureGrotto;
	private NpcStep talkToNatureSpirit;

	public BruhsailerStep68(BruhsailerGuide guide)
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
		coins = new ItemRequirement("Coins", ItemID.COINS, 5);
		bucket = new ItemRequirement("Bucket", ItemID.BUCKET_EMPTY).isNotConsumed();
		waterRunes = new ItemRequirement("Water runes", ItemID.WATERRUNE, -1);
		airStaff = new ItemRequirement("Staff of air", ItemID.STAFF_OF_AIR).isNotConsumed();
		lawRunes = new ItemRequirement("Law runes", ItemID.LAWRUNE, -1);
		runePickaxe = new ItemRequirement("Rune pickaxe", ItemID.RUNE_PICKAXE).isNotConsumed();
		brownApron = new ItemRequirement("Brown apron", ItemID.BROWN_APRON).isNotConsumed();
		mazeKey = new ItemRequirement("Maze key", ItemID.MELZARKEY).isNotConsumed();
		airRunes = new ItemRequirement("Air runes", ItemID.AIRRUNE, -1);
		mindRunes = new ItemRequirement("Mind runes", ItemID.MINDRUNE, -1);
		runeSword = new ItemRequirement("Rune sword", ItemID.RUNE_SWORD).isNotConsumed();
		food = new ItemRequirement("Salmon or trout", ItemID.TROUT, 10);
		food.addAlternates(ItemID.SALMON);
		secateurs = new ItemRequirement("Secateurs", ItemID.SECATEURS).isNotConsumed();
		symptomsList = new ItemRequirement("Symptoms list", ItemID.FAIRY_SYMPTOMS_LIST).isNotConsumed();
		draynorSkull = new ItemRequirement("Draynor skull", ItemID.FAIRY_SKULL).isNotConsumed();
		ghostspeak = new ItemRequirement("Ghostspeak amulet", ItemCollections.GHOSTSPEAK, 1, true).isNotConsumed();
		cowhides = new ItemRequirement("Cowhides", -1, 3);
	}

	private void setupSteps()
	{
		teleportToFalador = new DetailedQuestStep(guide, new WorldPoint(2964, 3378, 0),
			"Teleport to Falador and start the Step 68 sweep: diary tasks, Fairytale I setup, Melzar's Maze, " +
				"then the Nature Grotto for your magic secateurs.");
		teleportToFalador.addRequirement(coins);
		teleportToFalador.addRequirement(bucket);
		teleportToFalador.addRequirement(waterRunes);
		teleportToFalador.addRequirement(airStaff);
		teleportToFalador.addRequirement(lawRunes);
		teleportToFalador.addRequirement(runePickaxe);
		teleportToFalador.addRequirement(brownApron);
		teleportToFalador.addRequirement(mazeKey);
		teleportToFalador.addRequirement(airRunes);
		teleportToFalador.addRequirement(mindRunes);
		teleportToFalador.addRequirement(runeSword);
		teleportToFalador.addRequirement(food);
		teleportToFalador.addRequirement(secateurs);
		teleportToFalador.addRequirement(symptomsList);
		teleportToFalador.addRequirement(draynorSkull);
		teleportToFalador.addRequirement(ghostspeak);
		teleportToFalador.addRequirement(cowhides);

		getHaircut = new NpcStep(guide, NpcID.HAIRDRESSER, new WorldPoint(2945, 3380, 0),
			"Get a haircut from the Falador hairdresser for the diary.");

		fillBucketAtPump = new ObjectStep(guide, ObjectID.FAI_FALADOR_WATERPUMP, new WorldPoint(2947, 3382, 0),
			"Fill your bucket at the Falador pump for the diary.", bucket.highlighted());
		fillBucketAtPump.addIcon(ItemID.BUCKET_EMPTY);

		climbFaladorWall = new ObjectStep(guide, ObjectID.FAI_FALADOR_CASTLE_CRUMBLE_MID, new WorldPoint(2935, 3355, 0),
			"Climb over the western Falador wall, then continue Fairytale I up to the point where Mortifer gives you " +
				"the 3-item list for the magic secateurs.");

		talkToZandar = new NpcStep(guide, NpcID.ZANDAR_HORFYRE, new WorldPoint(2907, 3335, 2),
			"Talk to Zandar Horfyre in the Dark Wizards' Tower for Fairytale I.", symptomsList);

		talkToMortifer = new NpcStep(guide, NpcID.ELEMENTAL_WIZARD_BOSS, new WorldPoint(2991, 3270, 0),
			"Talk to Malignius Mortifer near Port Sarim to get the 3 items you need for the magic secateurs.", draynorSkull);

		doCraftingGuildDiaryStops = new DetailedQuestStep(guide, new WorldPoint(2938, 3280, 0),
			"Stop by the Crafting Guild on the way: wear your brown apron, mine a gold ore for the diary, and tan 2 " +
				"cowhides into soft leather and 1 into hard leather.");
		doCraftingGuildDiaryStops.addRequirement(runePickaxe);
		doCraftingGuildDiaryStops.addRequirement(brownApron);
		doCraftingGuildDiaryStops.addRequirement(cowhides);

		enterMelzarsMaze = new ObjectStep(guide, ObjectID.MELZARDOOR, new WorldPoint(2941, 3248, 0),
			"Complete Melzar's Maze for the map piece so Dragon Slayer I stays on route.", mazeKey, runeSword, food);

		collectFairytaleItems = new DetailedQuestStep(guide, new WorldPoint(3078, 3256, 0),
			"Collect Mortifer's 3 Fairytale items, then head toward Mort Myre. Suggested harder pickups: have Zahur " +
				"clean avantoe/irit, buy a snapdragon from Brimhaven Agility Arena, get white berries from Lava Isle or " +
				"chaos druid sources, and farm abyssal leeches for the nature talisman if needed.");

		enterNatureGrotto = new ObjectStep(guide, ObjectID.GROTTO_DOOR_DRUIDICSPIRIT, new WorldPoint(3440, 3337, 0),
			"Use the Shades of Mort'ton minigame teleport route to the Nature Grotto. Kill a snail for thin snail meat " +
				"and craft a snelm on the way before going inside.", ghostspeak, secateurs);

		talkToNatureSpirit = new NpcStep(guide, NpcID.FILLIMAN_TARLOCK_NS, new WorldPoint(3441, 9738, 1),
			"Bring Mortifer's 3 items to the Nature Spirit and make your magic secateurs.", ghostspeak, secateurs);

		teleportToFalador.withId(6801);
		getHaircut.withId(6802);
		fillBucketAtPump.withId(6803);
		climbFaladorWall.withId(6804);
		talkToZandar.withId(6805);
		talkToMortifer.withId(6806);
		doCraftingGuildDiaryStops.withId(6807);
		enterMelzarsMaze.withId(6808);
		collectFairytaleItems.withId(6809);
		enterNatureGrotto.withId(6810);
		talkToNatureSpirit.withId(6811);
	}

	public QuestStep getFirstStep()
	{
		return teleportToFalador;
	}

	public List<ItemRequirement> getItemRequirements()
	{
		return Arrays.asList(coins, bucket, waterRunes, airStaff, lawRunes, runePickaxe, brownApron, mazeKey,
			airRunes, mindRunes, runeSword, food, secateurs, symptomsList, draynorSkull, ghostspeak, cowhides);
	}

	public List<QuestStep> getSteps()
	{
		return Arrays.asList(teleportToFalador, getHaircut, fillBucketAtPump, climbFaladorWall, talkToZandar,
			talkToMortifer, doCraftingGuildDiaryStops, enterMelzarsMaze, collectFairytaleItems, enterNatureGrotto,
			talkToNatureSpirit);
	}

	public PanelDetails getPanel()
	{
		return new PanelDetails("Step 68: Falador Diary, Fairytale I & Melzar's Maze",
			getSteps(),
			coins, bucket, waterRunes, airStaff, lawRunes, runePickaxe, brownApron, mazeKey,
			airRunes, mindRunes, runeSword, food, secateurs, symptomsList, draynorSkull, ghostspeak,
			cowhides).withPanelId(68);
	}
}
