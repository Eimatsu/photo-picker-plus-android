In order to use the PhotoPicker+ component, you need to initialize it with configuration. 

Configuration builder
====
 
The Configuration builder allows you to choose which services (local and remote) your application is going to use. Local services included are: Camera media, All media, Last photo taken, Last video captured, Record video and Take photo. Remote supported services include: Google+, Google Drive, SkyDrive, Facebook, Instagram, Flickr, Picasa, YouTube and Dropbox.  
All options in Configuration builder are required for appropriately setting up the services, except <code>isMultiPicker(false)</code>, which is optional, with false as a default value, <code>supportImages(true)</code> with true as a default value, <code>supportVideos(true)</code> with true as a default value and <code>configUrl(url)</code>. If you want to use multipicking feature you should set <code>isMultiPicker(true)</code> option in the Configuration builder.  
<code>configUrl(url)</code> option must be initialized in the Configuration builder if you want to get the service list from a server. 
When started for the first time the app displays the initialized local and remote services, while on the second run it shows the complete list of services retrieved from the server if <code>configUrl(url)</code> option is initialized.  

<pre><code>
    Map<AccountType, DisplayType> map = new HashMap<AccountType, DisplayType>();
	  	map.put(AccountType.INSTAGRAM, DisplayType.LIST);

		PhotoPickerConfiguration config = new PhotoPickerConfiguration.Builder(
				getApplicationContext())
				.isMultiPicker(true)
				.defaultAccountDisplayType(DisplayType.LIST)
		  .accountDisplayType(map)
				.accountList(AccountType.FLICKR, AccountType.DROPBOX,
						AccountType.INSTAGRAM, AccountType.GOOGLE,
						AccountType.YOUTUBE)
				.localMediaList(LocalServiceType.ALL_MEDIA,
						LocalServiceType.CAMERA_MEDIA,
						LocalServiceType.RECORD_VIDEO,
						LocalServiceType.LAST_VIDEO_CAPTURED)
				.configUrl(ConfigEndpointURLs.SERVICES_CONFIG_URL)
				.supportImages(true).supportVideos(true).build();
		PhotoPicker.getInstance().init(config);
</code></pre>
    

Default configuration
====

If the local and remote services are not initialized, PhotoPicker will be initialized with default settings. DefaultConfigurationFactory sets <code>LocalMediaType.ALL_MEDIA</code> and <code>LocalMediaType.CAMERA_MEDIA</code> as local and <code>AccountType.FACEBOOK</code> and <code>AccountType.INSTAGRAM</code> as remote services.


Configuration URL
====

If you wish to configure services by getting a list from the server, you should create a file containing JSON model as the following one:
```
     {
        "services":[
                   "facebook",
                   "instagram",
                   "skydrive",
                   "googledrive",
                   "google",
                   "picasa",
                   "flickr",
                   "dropbox",
                   "youtube"],
         "local_features":[
                   "all_media",
                   "take_photo",
                   "last_photo_taken",
                   "camera_media",
                   "last_video_captured"
                   "record_video"]
     }
```

**NOTE:** Supported remote services include: Facebook, Instagram, Flickr, Picasa, Google, GoogleDrive, SkyDrive, Dropbox, YouTube.  
Supported local services include: All media, Camera media, Last photo taken, Take photo, Last video captured, Record video.
