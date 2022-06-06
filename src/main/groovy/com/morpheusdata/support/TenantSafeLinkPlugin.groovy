/**
@author Chris Taylor
**/

package com.morpheusdata.support

import com.morpheusdata.core.Plugin

class TenantSafeLinkPlugin extends Plugin {

	@Override
	String getCode() {
		return 'tenant-safe-link-generator-plugin'
	}

	@Override
	void initialize() {
		TenantSafeLinkProvider provider = new TenantSafeLinkProvider(this, morpheus)
		this.pluginProviders.put(provider.providerCode, provider)
		this.setName("Tenant Safe Link Generator Plugin")
	}

	@Override
	void onDestroy() {
	}
}
