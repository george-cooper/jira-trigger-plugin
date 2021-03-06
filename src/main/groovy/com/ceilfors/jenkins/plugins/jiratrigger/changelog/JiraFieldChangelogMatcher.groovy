package com.ceilfors.jenkins.plugins.jiratrigger.changelog

import com.atlassian.jira.rest.client.api.domain.FieldType
import com.atlassian.jira.rest.client.api.domain.IssueFieldId
import groovy.transform.EqualsAndHashCode
import groovy.transform.ToString
import hudson.Extension
import hudson.util.ComboBoxModel
import org.kohsuke.stapler.DataBoundConstructor
/**
 * @author ceilfors
 */
@ToString(includeSuper = true)
@EqualsAndHashCode(callSuper = true)
class JiraFieldChangelogMatcher extends ChangelogMatcher {

    @DataBoundConstructor
    JiraFieldChangelogMatcher(String field, String newValue, String oldValue) {
        super(FieldType.JIRA, field.trim(), newValue.trim(), oldValue.trim())
    }

    @SuppressWarnings('UnnecessaryQualifiedReference') // Can't remove qualifier, IntelliJ bug?
    @Extension
    static class JiraFieldChangelogMatcherDescriptor extends ChangelogMatcher.ChangelogMatcherDescriptor {

        public static final String DISPLAY_NAME = 'JIRA Field Matcher'

        @Override
        String getDisplayName() {
            DISPLAY_NAME
        }

        @SuppressWarnings('GroovyUnusedDeclaration') // jelly
        ComboBoxModel doFillFieldItems() {
            new ComboBoxModel(IssueFieldId.ids().toList())
        }
    }
}
