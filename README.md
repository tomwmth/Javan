# Javan

Javan is a very lightweight adaptation of the Riot Games League of Legends API with the using only dependency
being `org.json`

## Documentation

Documentation is available [here](https://javan.hawolt.com)

Your starting point should be the [Javan](https://javan.hawolt.com/com/hawolt/Javan.html) class

## Discord

since this code lacks documentation the best help you can get is my knowledge, proper questions can be asked in this [discord](https://discord.gg/3wknX5gxaW) server, please note that I will not guide you to achieve something or answer beginner level questions

## Rate Limiting

Rate Limits are handled by the library itself and will currently force your application into sleep when reached

You can create a custom Rate Limiting Strategy if needed by implementing the `RateLimitStrategy` interface


## Maven

to use this Library within your Maven project you will have to add the following repository

```
<repositories>
    <repository>
        <id>jitpack.io</id>
         <url>https://jitpack.io</url>
    </repository>
</repositories>
```

and then add the dependency

```
<dependency>
    <groupId>com.github.hawolt</groupId>
    <artifactId>Javan</artifactId>
    <version>main-SNAPSHOT</version>             
</dependency>
```

## Examples

Here are some example calls to get you started, these can also be found in the `test` directory

```java
import com.hawolt.api.*;
import com.hawolt.data.api.RankedQueue;
import com.hawolt.data.routing.Platform;
import com.hawolt.dto.league.v4.LeagueItemDTO;
import com.hawolt.dto.league.v4.LeagueListDTO;
import com.hawolt.dto.match.v5.match.MatchDto;
import com.hawolt.dto.summoner.v4.SummonerDto;
import com.hawolt.exceptions.DataNotFoundException;

import java.io.IOException;
import java.util.List;

public class Examples {
    public static void main(String[] args) throws DataNotFoundException, IOException {
        Javan.setRiotAPIKey(args[0]);
        SummonerDto summoner = SummonerAPI.getSummonerByName(Platform.EUW1, "Agurin");
        System.out.println(summoner);
        List<String> list = MatchAPI.getMatchListByPUUID(Platform.EUW1, summoner.getPUUID());
        if (!list.isEmpty()) {
            MatchDto match = MatchAPI.getMatch(list.get(0));
            System.out.println(match);
        }
        LeagueListDTO apex = LeagueAPI.getChallengerLeagues(Platform.EUW1, RankedQueue.RANKED_SOLO_5x5);
        List<LeagueItemDTO> challengers = apex.getEntries();
        System.out.println(challengers.get(0));
        LeagueItemDTO alpha = challengers.get(challengers.size() - 1);
        System.out.println(MasteryAPI.getPlayerTotalMasteryScore(Platform.EUW1, alpha.getSummonerId()));
        System.out.println(SpectatorAPI.getFeaturedGames(Platform.EUW1));
        System.out.println(ClashAPI.getTournaments(Platform.EUW1));
        System.out.println(ChampionAPI.getChampionRotations(Platform.EUW1));
    }
}
```

