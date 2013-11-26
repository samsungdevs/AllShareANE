/*
* Copyright 2013 Samsung Developer Relations Team (MSCSEA)
*
* Licensed under the Apache License, Version 2.0 (the "License");
* you may not use this file except in compliance with the License.
* You may obtain a copy of the License at
*
*     http://www.apache.org/licenses/LICENSE-2.0
*
* Unless required by applicable law or agreed to in writing, software
* distributed under the License is distributed on an "AS IS" BASIS,
* WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
* See the License for the specific language governing permissions and
* limitations under the License.
*/

package co.mscsea.allshareextension
{
	import flash.events.EventDispatcher;
	import flash.events.StatusEvent;
	import flash.external.ExtensionContext;
	
	public class AllShareExtension extends EventDispatcher {
		
		private var extContext:ExtensionContext;
		
		public function AllShareExtension()	{
			super();
			
			extContext = ExtensionContext.createExtensionContext("co.mscsea.allshare", "");
			if (!extContext) {
				throw new Error("Native extension not found!");
			}
			
			extContext.addEventListener(StatusEvent.STATUS, onStatus);
		}
		
		private function onStatus( event:StatusEvent ):void {

		}
		
		public function dispose():void { 
			extContext.dispose(); 
		}
				
		private function init():void {
			extContext.call("init");
		}
		
		public function startScreenShare():void {
			extContext.call("startScreenShare");
		}
		
		public function stopScreenShare():void {
			extContext.call("stopScreenShare");
		}
	}
}