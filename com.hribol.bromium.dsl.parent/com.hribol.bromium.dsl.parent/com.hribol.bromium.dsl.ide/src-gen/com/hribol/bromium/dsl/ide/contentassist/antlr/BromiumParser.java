/*
 * generated by Xtext 2.12.0
 */
package com.hribol.bromium.dsl.ide.contentassist.antlr;

import com.google.inject.Inject;
import com.hribol.bromium.dsl.ide.contentassist.antlr.internal.InternalBromiumParser;
import com.hribol.bromium.dsl.services.BromiumGrammarAccess;
import java.util.HashMap;
import java.util.Map;
import org.eclipse.xtext.AbstractElement;
import org.eclipse.xtext.ide.editor.contentassist.antlr.AbstractContentAssistParser;

public class BromiumParser extends AbstractContentAssistParser {

	@Inject
	private BromiumGrammarAccess grammarAccess;

	private Map<AbstractElement, String> nameMappings;

	@Override
	protected InternalBromiumParser createParser() {
		InternalBromiumParser result = new InternalBromiumParser(null);
		result.setGrammarAccess(grammarAccess);
		return result;
	}

	@Override
	protected String getRuleName(AbstractElement element) {
		if (nameMappings == null) {
			nameMappings = new HashMap<AbstractElement, String>() {
				private static final long serialVersionUID = 1L;
				{
					put(grammarAccess.getWebDriverActionAccess().getAlternatives(), "rule__WebDriverAction__Alternatives");
					put(grammarAccess.getVersionAccess().getAlternatives(), "rule__Version__Alternatives");
					put(grammarAccess.getModelAccess().getGroup(), "rule__Model__Group__0");
					put(grammarAccess.getModelAccess().getGroup_4(), "rule__Model__Group_4__0");
					put(grammarAccess.getApplicationActionAccess().getGroup(), "rule__ApplicationAction__Group__0");
					put(grammarAccess.getApplicationActionAccess().getGroup_2(), "rule__ApplicationAction__Group_2__0");
					put(grammarAccess.getApplicationActionAccess().getGroup_4(), "rule__ApplicationAction__Group_4__0");
					put(grammarAccess.getApplicationActionAccess().getGroup_5(), "rule__ApplicationAction__Group_5__0");
					put(grammarAccess.getElementWithIdIsPresentAccess().getGroup(), "rule__ElementWithIdIsPresent__Group__0");
					put(grammarAccess.getClickOnElementWithIdAccess().getGroup(), "rule__ClickOnElementWithId__Group__0");
					put(grammarAccess.getPageLoadAccess().getGroup(), "rule__PageLoad__Group__0");
					put(grammarAccess.getTypeTextInElementFoundByCssSelectorAccess().getGroup(), "rule__TypeTextInElementFoundByCssSelector__Group__0");
					put(grammarAccess.getThreeDottedVersionAccess().getGroup(), "rule__ThreeDottedVersion__Group__0");
					put(grammarAccess.getModelAccess().getNameAssignment_1(), "rule__Model__NameAssignment_1");
					put(grammarAccess.getModelAccess().getVersionAssignment_3(), "rule__Model__VersionAssignment_3");
					put(grammarAccess.getModelAccess().getBaseVersionAssignment_4_1(), "rule__Model__BaseVersionAssignment_4_1");
					put(grammarAccess.getModelAccess().getActionsAssignment_7(), "rule__Model__ActionsAssignment_7");
					put(grammarAccess.getApplicationActionAccess().getActionIdAssignment_1(), "rule__ApplicationAction__ActionIdAssignment_1");
					put(grammarAccess.getApplicationActionAccess().getPreconditionAssignment_2_1(), "rule__ApplicationAction__PreconditionAssignment_2_1");
					put(grammarAccess.getApplicationActionAccess().getWebDriverActionAssignment_3(), "rule__ApplicationAction__WebDriverActionAssignment_3");
					put(grammarAccess.getApplicationActionAccess().getPostconditionAssignment_4_3(), "rule__ApplicationAction__PostconditionAssignment_4_3");
					put(grammarAccess.getElementWithIdIsPresentAccess().getCssSelectorAssignment_4(), "rule__ElementWithIdIsPresent__CssSelectorAssignment_4");
					put(grammarAccess.getClickOnElementWithIdAccess().getCssSelectorAssignment_6(), "rule__ClickOnElementWithId__CssSelectorAssignment_6");
					put(grammarAccess.getPageLoadAccess().getSubpathAssignment_2(), "rule__PageLoad__SubpathAssignment_2");
					put(grammarAccess.getTypeTextInElementFoundByCssSelectorAccess().getTextAssignment_1(), "rule__TypeTextInElementFoundByCssSelector__TextAssignment_1");
					put(grammarAccess.getTypeTextInElementFoundByCssSelectorAccess().getCssSelectorAssignment_7(), "rule__TypeTextInElementFoundByCssSelector__CssSelectorAssignment_7");
					put(grammarAccess.getThreeDottedVersionAccess().getBigAssignment_0(), "rule__ThreeDottedVersion__BigAssignment_0");
					put(grammarAccess.getThreeDottedVersionAccess().getMediumAssignment_2(), "rule__ThreeDottedVersion__MediumAssignment_2");
					put(grammarAccess.getThreeDottedVersionAccess().getSmallAssignment_4(), "rule__ThreeDottedVersion__SmallAssignment_4");
				}
			};
		}
		return nameMappings.get(element);
	}
			
	@Override
	protected String[] getInitialHiddenTokens() {
		return new String[] { "RULE_WS", "RULE_ML_COMMENT", "RULE_SL_COMMENT" };
	}

	public BromiumGrammarAccess getGrammarAccess() {
		return this.grammarAccess;
	}

	public void setGrammarAccess(BromiumGrammarAccess grammarAccess) {
		this.grammarAccess = grammarAccess;
	}
}