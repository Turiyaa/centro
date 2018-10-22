package com.sunyoswego.centro;

import org.omg.CORBA.Request;
//database Centro
//OswegoDB -> Centro : data request using python script
//Centro -> OswegoDB: sends back data

public class Uml {
	@startuml
	box "Centro Web App"
	actor User
	participant "GUI" as A
	participant "BusStops" as B
	participant "BusService" as C
	database OswegoDB
	User -> A : request
	A -> B : bust stop list
	B -> OswegoDB : getBusStops
	OswegoDB --> A : returns bus stops
	A -> User: display bus stop list
	User -> A :selects particular bus stops
	A -> C : sends bus stop info
	C -> OswegoDB: query with bus info
	OswegoDB --> C : retrived bus info
	C --> A : cal bus stop avg arrival time
	A -> User: displays avg time and histogram
	end box
	participant "Moxie Server" as S
	box "Centro System"
	database centro
	S -> centro : python script to request centro data
	centro --> S : sends back data 
	S --> OswegoDB : populates OswegoDB
	end box
	@enduml
}
