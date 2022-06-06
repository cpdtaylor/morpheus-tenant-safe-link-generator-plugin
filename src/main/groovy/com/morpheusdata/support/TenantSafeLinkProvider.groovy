package com.morpheusdata.support

import com.morpheusdata.core.AbstractGlobalUIComponentProvider
import com.morpheusdata.core.MorpheusContext
import com.morpheusdata.core.Plugin
import com.morpheusdata.model.Account
import com.morpheusdata.model.Instance
import com.morpheusdata.model.TaskConfig
import com.morpheusdata.model.ContentSecurityPolicy
import com.morpheusdata.model.User
import com.morpheusdata.views.HTMLResponse
import com.morpheusdata.views.ViewModel
import com.morpheusdata.model.UIScope
import com.morpheusdata.model.Permission


class TenantSafeLinkProvider extends AbstractGlobalUIComponentProvider {
	Plugin plugin
	MorpheusContext morpheus

	TenantSafeLinkProvider(Plugin plugin, MorpheusContext context) {
		this.plugin = plugin
		this.morpheus = context
	}
	
	@Override
	MorpheusContext getMorpheus() {
		morpheusContext
	}

	@Override
	Plugin getPlugin() {
		plugin
	}

	@Override
	String getCode() {
		'tenantSafeLinkProvider'
	}
	
	String getProviderCode() {
		'tenantSafeLinkProvider'
	}

	@Override
	String getName() {
		'Tenant Safe Link Provider'
	}
	
	String getProviderName() {
		'Tenant Safe Link Provider'
	}

	@Override
	HTMLResponse renderTemplate(User user, Account account) {
		ViewModel<String> model = new ViewModel<String>()
		def nonse = morpheus.getWebRequest().getNonceToken()
		model.object = [:]
		model.object.nonse = nonse.toString()
		model.object.accountId = account.id?.toString()
		getRenderer().renderTemplate("hbs/linkgen", model)
	}

	@Override
	Boolean show(User user, Account account) {
		def show = true
		return show
	}

	@Override
	ContentSecurityPolicy getContentSecurityPolicy() {
		def csp = new ContentSecurityPolicy()
		csp
	}
}
