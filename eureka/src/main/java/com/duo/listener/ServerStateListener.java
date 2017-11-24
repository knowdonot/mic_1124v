package com.duo.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceCanceledEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaInstanceRegisteredEvent;
import org.springframework.cloud.netflix.eureka.server.event.EurekaServerStartedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import com.netflix.appinfo.InstanceInfo;


@Component
public class ServerStateListener implements ServletContextListener{

	
	
	@EventListener
	public void listen(EurekaServerStartedEvent startEv){
		System.out.println(startEv.getTimestamp()+"====================start======="+startEv.getSource());
	}
	
	
	@EventListener
	public void listen(EurekaInstanceRegisteredEvent regEv){
		 InstanceInfo instanceInfo = regEv.getInstanceInfo(); 
		System.out.println(regEv.getTimestamp()+"====================Registere======="+instanceInfo.getAppName()+"=="+instanceInfo.getIPAddr()+"--"+instanceInfo.getHealthCheckUrl()+"==="+instanceInfo.toString());
	}
	

	@EventListener
	public void listen(EurekaInstanceCanceledEvent cancelEv){
		System.out.println(cancelEv.getTimestamp()+"====================Cancel======AppName="+cancelEv.getAppName()+"=serverId="+cancelEv.getServerId());
	}


	@Override
	public void contextInitialized(ServletContextEvent sce) {
		System.out.println("-----init---------------------");
	}


	@Override
	public void contextDestroyed(ServletContextEvent sce) {
		System.out.println("-----destroy---------------------");
	}
}
