# study-springboot3

## Spring Boot 3 で変わること

- 参考
    - https://qiita.com/kazokmr/items/ae0b70cfbc06ec344c44
    - https://ik.am/entries/715

- 変更点:
    - JDK: 17以上
    - JakartaEE:
        - バージョン: 10。要件としては 9以上
        - パッケージ名: javax.* → jakarta.*
    - Spring framework:
        - バージョン: 6
    - Spring Security
        - mvcMatchers -> requestMatchers
        - ignoringAntMatchers -> ignoringRequestMatchers
        - `@EnableWebSecurity` から `@Configuration` が 5.8 から内包されなくなった。明確に `@Configuration` の記載が必要。
            - `@Configuration` を書かないことで Spring Securty を依存関係に含めていなければ Bean として認識されないという効果があったが、
                同様の効果を狙うなら `@ConditionalOnClass` などを併用する必要あり。
    - Spring Cloud Slehth -> Micrometer Tracing
    - Java Interface client
        - お手軽に RESTクライアントが作成できる。
    - AOT & Native Support
        - Spring Native が取り込まれた。
        - AOT
            - 事前に ComponentScan 済のソースコード生成
            - CGLibによる動的プロキシも事前にバイトコード生成
            - nativeじゃないときも有用
        - Native
            - `@ConfigurationProperty` のネストしたプロパティのバインディングには、`@NestedConfigurationProperty`

## WebService

- https://eclipse-ee4j.github.io/metro-jax-ws/
