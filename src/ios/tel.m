/********* tel.m Cordova Plugin Implementation *******/

#import <Cordova/CDV.h>

@interface tel : CDVPlugin {
  // Member variables go here.
}

- (void)open:(CDVInvokedUrlCommand*)command;
@end

@implementation tel

- (void)open:(CDVInvokedUrlCommand*)command
{
    CDVPluginResult* pluginResult = nil;
    NSString* echo = [command.arguments objectAtIndex:0];
    if (echo != nil && [echo length] > 0) {
        NSMutableString * str=[[NSMutableString alloc] initWithFormat:@"telprompt://%@",echo];
                    //NSLog(@"str======%@",str);
        [[UIApplication sharedApplication] openURL:[NSURL URLWithString:str]];
    } else {
        pluginResult = [CDVPluginResult resultWithStatus:CDVCommandStatus_ERROR];
    }

    [self.commandDelegate sendPluginResult:pluginResult callbackId:command.callbackId];
}

@end
