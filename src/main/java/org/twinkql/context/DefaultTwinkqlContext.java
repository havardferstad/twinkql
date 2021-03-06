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

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

import org.twinkql.instance.Instantiator;
import org.twinkql.result.beans.reasoning.PropertyReasoner;

import com.hp.hpl.jena.query.QueryExecution;

import org.twinkql.model.SparqlMap;
import org.twinkql.model.TwinkqlConfig;

/**
 * The Class DefaultTwinkqlContext.
 *
 * @author <a href="mailto:kevin.peterson@mayo.edu">Kevin Peterson</a>
 */
public class DefaultTwinkqlContext implements TwinkqlContext {
	
	private Set<SparqlMap> sparqlMaps = new HashSet<SparqlMap>();
	
	private QueryExecutionProvider queryExecutionProvider;
	
	private Set<Instantiator> instantiators;
	
	private TwinkqlConfig twinkqlConfig;
	
	private Set<PropertyReasoner> propertyReasoners;
	
	/**
	 * Instantiates a new default twinkql context.
	 */
	public DefaultTwinkqlContext(){
		super();
	}
	
	/**
	 * Instantiates a new default twinkql context.
	 *
	 * @param twinkqlConfig the twinkql config
	 * @param queryExecutionProvider the query execution provider
	 * @param maps the maps
	 */
	public DefaultTwinkqlContext(TwinkqlConfig twinkqlConfig, QueryExecutionProvider queryExecutionProvider, Set<Instantiator> instantiators, SparqlMap...maps){
		this(twinkqlConfig, queryExecutionProvider, instantiators, new HashSet<SparqlMap>(Arrays.asList(maps)));
	}
	
	/**
	 * Instantiates a new default twinkql context.
	 *
	 * @param twinkqlConfig the twinkql config
	 * @param queryExecutionProvider the query execution provider
	 * @param sparqlMaps the sparql maps
	 */
	public DefaultTwinkqlContext(TwinkqlConfig twinkqlConfig, QueryExecutionProvider queryExecutionProvider, Set<Instantiator> instantiators, Set<SparqlMap> sparqlMaps){
		this.twinkqlConfig = twinkqlConfig;
		this.queryExecutionProvider = queryExecutionProvider;
		this.sparqlMaps = sparqlMaps;
		this.instantiators = instantiators;
	}

	/* (non-Javadoc)
	 * @see edu.mayo.twinkql.TwinkqlContext#getSparqlMap(java.lang.String, java.lang.String)
	 */
	public Set<SparqlMap> getSparqlMaps() {
		return this.sparqlMaps;
	}

	/* (non-Javadoc)
	 * @see edu.mayo.twinkql.context.TwinkqlContext#getQueryExecution(com.hp.hpl.jena.query.Query)
	 */
	public QueryExecution getQueryExecution(String query) {
		return this.queryExecutionProvider.provideQueryExecution(query);
	}

	/* (non-Javadoc)
	 * @see edu.mayo.twinkql.context.TwinkqlContext#getInstantiators()
	 */
	public Set<Instantiator> getInstantiators() {
		return this.instantiators;
	}

	/* (non-Javadoc)
	 * @see edu.mayo.twinkql.context.TwinkqlContext#getTwinkqlConfig()
	 */
	public TwinkqlConfig getTwinkqlConfig() {
		return this.twinkqlConfig;
	}

	/**
	 * Gets the query execution provider.
	 *
	 * @return the query execution provider
	 */
	public QueryExecutionProvider getQueryExecutionProvider() {
		return queryExecutionProvider;
	}

	/**
	 * Sets the query execution provider.
	 *
	 * @param queryExecutionProvider the new query execution provider
	 */
	public void setQueryExecutionProvider(
			QueryExecutionProvider queryExecutionProvider) {
		this.queryExecutionProvider = queryExecutionProvider;
	}

	/**
	 * Sets the sparql maps.
	 *
	 * @param sparqlMaps the new sparql maps
	 */
	public void setSparqlMaps(Set<SparqlMap> sparqlMaps) {
		this.sparqlMaps = sparqlMaps;
	}

	/**
	 * Sets the instantiators.
	 *
	 * @param instantiators the new instantiators
	 */
	public void setInstantiators(Set<Instantiator> instantiators) {
		this.instantiators = instantiators;
	}

	/**
	 * Sets the twinkql config.
	 *
	 * @param twinkqlConfig the new twinkql config
	 */
	public void setTwinkqlConfig(TwinkqlConfig twinkqlConfig) {
		this.twinkqlConfig = twinkqlConfig;
	}

	/* (non-Javadoc)
	 * @see edu.mayo.twinkql.context.TwinkqlContext#getPropertyReasoners()
	 */
	public Set<PropertyReasoner> getPropertyReasoners() {
		return propertyReasoners;
	}

	/**
	 * Sets the property reasoners.
	 *
	 * @param propertyReasoners the new property reasoners
	 */
	public void setPropertyReasoners(Set<PropertyReasoner> propertyReasoners) {
		this.propertyReasoners = propertyReasoners;
	}
	
}
