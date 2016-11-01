# Getty Images API SDK 

Seamlessly integrate Getty Images' expansive digital content, powerful search technology, and rich metadata into your publishing tools, products and services!

- Search for images from our extensive creative and editorial catalogs.
- Get image metadata.
- Download files using your Getty Images products (e.g., Editorial subscriptions, Easy Access, Thinkstock Subscriptions, and Image Packs).

## Minimum Requirements
* You have Java SDK installed.
* You have "Getty Test" credentials from the [Getty Images API Portal](https://developer.gettyimages.com/member/register)
* You have [IntelliJ IDEA](https://www.jetbrains.com/idea/) installed
* You have [Maven](https://maven.apache.org/) installed

## Import the SDK to your project via IntelliJ+Maven

Import the module into your project

```
File | New | Module from Existing Sources...
Point to the *gettyimagesapi-sdk* folder
Select *Maven* via *Import module from external model* window
Click on Next, Next, then click Finish
```

## Usage
See *gettyimagesapi-examples* folder for examples

### Run Example via Maven
You can run the examples by using [Maven's](http://www.mojohaus.org/exec-maven-plugin/usage.html) `exec:java` call. The following shows how to run the creative search example:

```
(Edit CreativeSearch.java to include correct API Key, Secret, Username, and Password)
cd gettyimagesapi-examples
mvn clean install
mvn exec:java -Dexec.mainClass="com.gettyimages.search.CreativeSearch"
```

## Contributing

1. Fork it ( https://github.com/[my-github-username]/ConnectSdk/fork )
2. Update the submodules (`git submodule update --init`)
2. Create your feature branch (`git checkout -b my-new-feature`)
3. Commit your changes (`git commit -am 'Add some feature'`)
4. Push to the branch (`git push origin my-new-feature`)
5. Create a new Pull Request

### Setup Environment Variables

The tests expect credentials to be stored in environment variables. The following are required to be set:

* *GettyImagesApi_ApiKey*: API key assigned when you registered
* *GettyImagesApi_ApiSecret*: API secret assigned when you registered
* *GettyImagesApi_UserName*: a Getty Images user. Create one at the Getty Images website.
* *GettyImagesApi_UserPassword*: Getty Images user's password

## Wish List
Our wish-list is (in no particular order):

* Add more examples to gettyimagesapi-examples
* Implement more features!
