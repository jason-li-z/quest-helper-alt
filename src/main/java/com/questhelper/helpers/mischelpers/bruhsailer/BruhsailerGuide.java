package com.questhelper.helpers.mischelpers.bruhsailer;

import com.questhelper.panel.PanelDetails;
import com.questhelper.questhelpers.BasicQuestHelper;
import com.questhelper.requirements.Requirement;
import com.questhelper.requirements.item.ItemRequirement;
import com.questhelper.steps.ConditionalStep;
import com.questhelper.steps.QuestStep;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BruhsailerGuide extends BasicQuestHelper
{
	private BruhsailerStep65 step65;
	private BruhsailerStep66 step66;
	private BruhsailerStep67 step67;
	private BruhsailerStep68 step68;
	private BruhsailerStep69 step69;
	private BruhsailerStep70 step70;
	private BruhsailerStep71 step71;
	private BruhsailerStep72 step72;
	private BruhsailerStep73 step73;
	private BruhsailerStep74 step74;
	private BruhsailerStep75 step75;

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

		step68 = new BruhsailerStep68(this);
		step68.setup();

		step69 = new BruhsailerStep69(this);
		step69.setup();

		step70 = new BruhsailerStep70(this);
		step70.setup();

		step71 = new BruhsailerStep71(this);
		step71.setup();

		step72 = new BruhsailerStep72(this);
		step72.setup();

		step73 = new BruhsailerStep73(this);
		step73.setup();

		step74 = new BruhsailerStep74(this);
		step74.setup();

		step75 = new BruhsailerStep75(this);
		step75.setup();
	}

	@Override
	public Map<Integer, QuestStep> loadSteps()
	{
		initializeRequirements();
		setupSteps();

		Map<Integer, QuestStep> steps = new HashMap<>();

		steps.put(0, new ConditionalStep(this, step65.getFirstStep()).withId(65));
		steps.put(65, step65.getFirstStep());
		steps.put(66, step66.getFirstStep());
		steps.put(67, step67.getFirstStep());
		steps.put(68, step68.getFirstStep());
		steps.put(69, step69.getFirstStep());
		steps.put(70, step70.getFirstStep());
		steps.put(71, step71.getFirstStep());
		steps.put(72, step72.getFirstStep());
		steps.put(73, step73.getFirstStep());
		steps.put(74, step74.getFirstStep());
		steps.put(75, step75.getFirstStep());

		addManualSubsteps(steps, step65.getSteps());
		addManualSubsteps(steps, step66.getSteps());
		addManualSubsteps(steps, step67.getSteps());
		addManualSubsteps(steps, step68.getSteps());
		addManualSubsteps(steps, step69.getSteps());
		addManualSubsteps(steps, step70.getSteps());
		addManualSubsteps(steps, step71.getSteps());
		addManualSubsteps(steps, step72.getSteps());
		addManualSubsteps(steps, step73.getSteps());
		addManualSubsteps(steps, step74.getSteps());
		addManualSubsteps(steps, step75.getSteps());

		return steps;
	}

	private void addManualSubsteps(Map<Integer, QuestStep> steps, Collection<QuestStep> manualSteps)
	{
		for (QuestStep step : manualSteps)
		{
			if (step.getId() != null)
			{
				steps.put(step.getId(), step);
			}
		}
	}

	@Override
	public List<ItemRequirement> getItemRequirements()
	{
		QuestStep activeStep = getActiveBruhsailerStep();
		if (activeStep == null)
		{
			return Collections.emptyList();
		}

		for (PanelDetails panel : getPanels())
		{
			if (panel.contains(activeStep))
			{
				return getPanelItemRequirements(panel);
			}
		}

		return Collections.emptyList();
	}

	private QuestStep getActiveBruhsailerStep()
	{
		if (getCurrentStep() != null)
		{
			QuestStep activeStep = getCurrentStep().getActiveStep();
			return activeStep != null ? activeStep : getCurrentStep();
		}

		if (steps == null)
		{
			return null;
		}

		int activeState = selectedStateOverride != null ? selectedStateOverride : getVar();
		QuestStep activeStep = steps.get(activeState);
		if (activeStep == null)
		{
			return null;
		}

		QuestStep resolvedActiveStep = activeStep.getActiveStep();
		return resolvedActiveStep != null ? resolvedActiveStep : activeStep;
	}

	private List<ItemRequirement> getPanelItemRequirements(PanelDetails panel)
	{
		if (panel.getRequirements() == null)
		{
			return Collections.emptyList();
		}

		List<ItemRequirement> itemRequirements = new ArrayList<>();
		for (Requirement requirement : panel.getRequirements())
		{
			if (requirement instanceof ItemRequirement)
			{
				itemRequirements.add((ItemRequirement) requirement);
			}
		}

		return itemRequirements;
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
		if (step68 != null)
		{
			panels.add(step68.getPanel());
		}
		if (step69 != null)
		{
			panels.add(step69.getPanel());
		}
		if (step70 != null)
		{
			panels.add(step70.getPanel());
		}
		if (step71 != null)
		{
			panels.add(step71.getPanel());
		}
		if (step72 != null)
		{
			panels.add(step72.getPanel());
		}
		if (step73 != null)
		{
			panels.add(step73.getPanel());
		}
		if (step74 != null)
		{
			panels.add(step74.getPanel());
		}
		if (step75 != null)
		{
			panels.add(step75.getPanel());
		}

		return panels;
	}
}
