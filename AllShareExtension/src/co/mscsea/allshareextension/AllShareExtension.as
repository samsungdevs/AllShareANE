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