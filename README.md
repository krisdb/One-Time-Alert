# One-Time-Alert

A simple utility library for creating one-time alerts for users.
```gradle
repositories {
  google()
  mavenCentral()
}

dependencies {
  implementation 'com.krisdb.onetimealert:1.0.0'
}
```

Example:

```java
OneTimeAlert.Toast(this, "toast_alert_1", "Hello, World");
        
OneTimeAlert.Dialog(this, "toast_alert_2", "Hello, World");

OneTimeAlert.Snackbar(this, "toast_alert_3", "Hello, World");

```
