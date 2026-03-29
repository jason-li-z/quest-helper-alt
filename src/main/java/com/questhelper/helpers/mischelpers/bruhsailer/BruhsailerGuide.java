package com.questhelper.helpers.mischelpers.bruhsailer;

import com.questhelper.panel.PanelDetails;
import com.questhelper.questhelpers.BasicQuestHelper;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.steps.QuestStep;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruhsailerGuide extends BasicQuestHelper
{
	private BruhsailerStep65 step65;
	private BruhsailerStep66 step66;
	private BruhsailerStep67 step67;

	@Override
	protected void setupZones()
	{
	}

	@Override
	protected void setupRequirements()
	{
	}

	public void setupSteps()
	{
		step65 = new BruhsailerStep65(this);
		step65.setup();

		step66 = new BruhsailerStep66(this);
		step66.setup();

		step67 = new BruhsailerStep67(this);
		step67.setup();
	}

	@Override
	public Map<Integer, QuestStep> loadSteps()
	{
		initializeRequirements();
		setupSteps();

		Map<Integer, QuestStep> steps = new HashMap<>();

		ConditionalStep guideStep = new ConditionalStep(this, step65.getFirstStep());
		steps.put(0, guideStep);

		return steps;
	}

	@Override
	public List<ItemRequirement> getItemRequirements()
	{
		List<ItemRequirement> reqs = new ArrayList<>();
		if (step65 != null)
		{
			reqs.addAll(step65.getItemRequirements());
		}
		if (step66 != null)
		{
			reqs.addAll(step66.getItemRequirements());
		}
		if (step67 != null)
		{
			reqs.addAll(step67.getItemRequirements());
		}
		return reqs;
	}

	@Override
	public List<PanelDetails> getPanels()
	{
		List<PanelDetails> panels = new ArrayList<>();

		if (step65 != null)
		{
			panels.add(step65.getPanel());
		}
		if (step66 != null)
		{
			panels.add(step66.getPanel());
		}
		if (step67 != null)
		{
			panels.add(step67.getPanel());
		}

		return panels;
	}
}
