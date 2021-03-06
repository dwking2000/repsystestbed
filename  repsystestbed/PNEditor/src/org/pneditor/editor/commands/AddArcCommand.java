/*
 * Copyright (C) 2008-2010 Martin Riesz <riesz.martin at gmail.com>
 * 
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */

package org.pneditor.editor.commands;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.pneditor.petrinet.Arc;
import org.pneditor.petrinet.PlaceNode;
import org.pneditor.petrinet.Subnet;
import org.pneditor.petrinet.Transition;
import org.pneditor.util.Command;

import cu.rst.core.petrinet.PetriNetEdge;

/**
 * 
 * @author Martin Riesz <riesz.martin at gmail.com>
 */
public class AddArcCommand implements Command
{

	private Subnet parentSubnet;
	private PlaceNode placeNode;
	private Transition transition;
	private boolean placeToTransition;
	private Arc createdArc;
	
	private Logger logger = LogManager.getLogger(AddArcCommand.class.getName());

	public AddArcCommand(PlaceNode placeNode, Transition transition,
			boolean placeToTransition)
	{
		this.parentSubnet = placeNode.getParentSubnet();
		this.placeNode = placeNode;
		this.transition = transition;
		this.placeToTransition = placeToTransition;
	}

	public void execute()
	{
		if(placeNode.getPlace().getRSTPlace().getContainedElement()!=null && transition.getRSTTransition().getAlg()!=null)
		{
			createdArc = new Arc(placeNode, transition, placeToTransition);
			parentSubnet.addElement(createdArc);
			logger.debug("Adding arc.");
			cu.rst.core.petrinet.PetriNet workflow = placeNode.getPlace().getRSTPlace().getWorkflow();
			try
			{  
				PetriNetEdge pne = null;
				if(placeToTransition)
				{
					pne = workflow.addEdge(placeNode.getPlace().getRSTPlace(), transition.getRSTTransition(), 1);
				}
				else
				{
					pne = workflow.addEdge(transition.getRSTTransition(), placeNode.getPlace().getRSTPlace(), 1);
				}
				if(pne != null) logger.debug("Arc added. " + pne);
					
			} 
			catch (Exception e)
			{
				logger.error(e);
			}
		}
		
		
	}

	public void undo()
	{
		new DeleteElementCommand(createdArc).execute();
	}

	public void redo()
	{
		parentSubnet.addElement(createdArc);
	}

	@Override
	public String toString()
	{
		return "Add arc";
	}

	public Arc getCreatedArc()
	{ // TODO: check usage
		return createdArc;
	}
}
