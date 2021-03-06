/*
 * Copyright: (c) 2004-2011 Mayo Foundation for Medical Education and 
 * Research (MFMER). All rights reserved. MAYO, MAYO CLINIC, and the
 * triple-shield Mayo logo are trademarks and service marks of MFMER.
 *
 * Except as contained in the copyright notice above, or as used to identify 
 * MFMER as the author of this software, the trade names, trademarks, service
 * marks, or product names of the copyright holder shall not be used in
 * advertising, promotion or otherwise in connection with this software without
 * prior written authorization of the copyright holder.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.twinkql.context;

import java.util.Set;

import org.twinkql.instance.Instantiator;
import org.twinkql.result.beans.reasoning.PropertyReasoner;

import com.hp.hpl.jena.query.QueryExecution;

import org.twinkql.model.SparqlMap;
import org.twinkql.model.TwinkqlConfig;

/**
 * A TwinkqlContext defines the configuration information for Twinkql. Most users will not
 * need to implement this, as {@link TwinkqlContextFactory} or {@link SpringTwinkqlContextFactory}
 * (or subclasses thereof) should provide most of the needed functionality.
 * 
 * @see DefaultTwinkqlContext
 * @see TwinkqlContextFactory
 * @see SpringTwinkqlContextFactory
 *
 * @author <a href="mailto:kevin.peterson@mayo.edu">Kevin Peterson</a>
 */
public interface TwinkqlContext {
	
	/**
	 * Gets the sparql map.
	 *
	 * @return the sparql map
	 */
	public Set<SparqlMap> getSparqlMaps();
	
	/**
	 * Gets the query execution.
	 *
	 * @param query the query
	 * @return the query execution
	 */
	public QueryExecution getQueryExecution(String query);
	
	/**
	 * Gets the twinkql config.
	 *
	 * @return the twinkql config
	 */
	public TwinkqlConfig getTwinkqlConfig();
	
	/**
	 * Gets the instantiators.
	 *
	 * @return the instantiators
	 */
	public Set<Instantiator> getInstantiators();
	
	/**
	 * Gets the property reasoners.
	 *
	 * @return the property reasoners
	 */
	public Set<PropertyReasoner> getPropertyReasoners();
}
