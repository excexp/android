# Demo for DNS over HTTPS

### 目前使用自建 DNS 服务器的话，下面代码会引起崩溃

// 看日志是找系统的域名服务器，使用 doh 方式去查询 dns.totemtec.com 去了，连不上就崩溃
// 这里域名服务器可以考虑用 IP 地址，不过 IP 的 SSL 证书很难获得
```kotlin
val appCache = Cache(File("cacheDir", "okhttpcache"), 10 * 1024 * 1024)
val bootstrapClient = OkHttpClient.Builder().cache(appCache).build()

val dns = DnsOverHttps.Builder().client(bootstrapClient)
.url("https://dns.totemtec.com/dns-query".toHttpUrl())
.bootstrapDnsHosts(InetAddress.getByName("49.233.245.5"), InetAddress.getByName("49.233.245.5"))
.build()

val client = bootstrapClient.newBuilder().dns(dns).build()
```

### 解决方案是使用 MyDNS，自己实现 DNS 查询

// 这里的域名和IP地址，可以由服务器的 API 接口返回给应用即可

```java
public class MyDns implements Dns {
    @NonNull
    @Override
    public List<InetAddress> lookup(@NonNull String s) throws UnknownHostException {

        InetAddress address = InetAddress.getByName("49.233.245.5") ;
        return asList(address);
    }
}
```

# 自建 DNS 服务器使用 CoreDNS，配置文件为

Corefile
```
https://. {

    tls /etc/nginx/ssl/dns.totemtec.com.pem /etc/nginx/ssl/dns.totemtec.com.key {
        client_auth nocert
    }


    hosts {
        49.233.245.5   test.urln.cn
        fallthrough
    }

    forward . 114.114.114.114
    log
    errors
}
```