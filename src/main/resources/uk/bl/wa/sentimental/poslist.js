/*
 * #%L
 * SentimentalJ
 * %%
 * Copyright (C) 2012 - 2013 The British Library
 * %%
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 * 
 * The above copyright notice and this permission notice shall be included in
 * all copies or substantial portions of the Software.
 * 
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN
 * THE SOFTWARE.
 * #L%
 */
var pos5 = ['breathtaking','hurrah','outstanding','superb','thrilled'];

var pos4 = ['amazing','awesome','brilliant','ecstatic','euphoric','exuberant','fabulous','fantastic',
'fun','funnier','funny','godsend','heavenly','lifesaver','lmao','lmfao','masterpiece','masterpieces',
'miracle','overjoyed','rapturous','rejoice','rejoiced','rejoices','rejoicing','rofl','roflcopter',
'roflmao','rotfl','rotflmfao','rotflol','stunning','terrific','triumph','triumphant','win','winner',
'winning','wins','wonderful','wooo','woow','wow','wowow','wowww'];

var pos3 = ['admire','admired','admires','admiring','adorable','adore','adored','adores','affection',
'affectionate','amuse','amused','amusement','amusements','astound','astounded','astounding',
'astoundingly','astounds','audacious','award','awarded','awards','beatific','beauties','beautiful',
'beautifully','beautify','beloved','best','blessing','bliss','blissful','blockbuster','breakthrough',
'captivated','celebrate','celebrated','celebrates','celebrating','charm','charming','cheery','classy',
'coolstuff','dearly','delight','delighted','delighting','delights','devoted','elated','elation',
'enrapture','enthral','enthusiastic','euphoria','excellence','excellent','excite','excited',
'excitement','exciting','exhilarated','exhilarates','exhilarating','exultant','exultantly','faithful',
'fan','fascinate','fascinated','fascinates','fascinating','ftw','gallant','gallantly','gallantry',
'genial','glad','glamorous','glamourous','glee','gleeful','good','goodness','gracious','grand',
'grateful','great','greater','greatest','haha','hahaha','hahahah','happiness','happy','heartfelt',
'heroic','humerous','impress','impressed','impresses','impressive','inspiring','joy','joyful',
'joyfully','joyous','jubilant','kudos','lawl','lol','lovable','love','loved','lovelies','lovely',
'loyal','loyalty','luck','luckily','lucky','marvel','marvelous','marvels','medal','merry','mirth',
'mirthful','mirthfully','nice','ominous','once-in-a-lifetime','paradise','perfect','perfectly',
'pleasant','pleased','pleasure','popular','praise','praised','praises','praising','prosperous',
'rightdirection','rigorous','rigorously','scoop','sexy','soothe','soothed','soothing','sparkle',
'sparkles','sparkling','splendid','successful','super','vibrant','vigilant','visionary','vitality',
'vivacious','wealth','winwin','won','woo','woohoo','worshiped','yummy'];

var pos2 = ['abilities','ability','absolve','absolved','absolves','absolving','accomplish',
'accomplished','accomplishes','acquit','acquits','acquitted','acquitting','advantage','advantages',
'adventure','adventures','adventurous','agog','agreeable','amaze','amazed','amazes','ambitious',
'appease','appeased','appeases','appeasing','applaud','applauded','applauding','applauds','applause',
'appreciate','appreciated','appreciates','appreciating','appreciation','approval','approved',
'approves','asset','assets','astonished','attracting','attraction','attractions','avid','backing',
'bargain','benefit','benefits','benefitted','benefitting','better','bless','blesses','blithe',
'bold','boldly','brave','brightest','brisk','buoyant','calm','calmed','calming','calms','care',
'careful','carefully','cares','chance','chances','cheer','cheered','cheerful','cheering','cheers',
'cherish','cherished','cherishes','cherishing','chic','clarifies','clarity','clean','cleaner',
'clever','comfort','comfortable','comforting','comforts','commend','commended','commitment',
'compassionate','competent','competitive','comprehensive','conciliate','conciliated','conciliates',
'conciliating','confidence','confident','congrats','congratulate','congratulation','congratulations',
'consent','consents','consolable','convivial','courage','courageous','courteous','courtesy',
'coziness','creative','cute','daredevil','daring','dauntless','dear','debonair','dedicated',
'defender','defenders','desirable','desired','desirous','determined','eager','earnest','ease',
'effective','effectively','elegant','elegantly','empathetic','enchanted','encourage','encouraged',
'encouragement','encourages','endorse','endorsed','endorsement','endorses','energetic','enjoy',
'enjoying','enjoys','enlighten','enlightened','enlightening','enlightens','entertaining','entrusted',
'esteemed','ethical','exasperated','exclusive','exonerate','exonerated','exonerates','exonerating',
'fair','favor','favored','favorite','favorited','favorites','favors','fearless','fervent','fervid',
'festive','fine','flagship','focused','fond','fondness','fortunate','freedom','friendly','frisky',
'fulfill','fulfilled','fulfills','funky','futile','gain','gained','gaining','gains','generous','gift',
'glorious','glory','gratification','greetings','growth','ha','hail','hailed','hardier','hardy',
'healthy','heaven','help','helpful','helping','helps','hero','heroes','highlight','hilarious','honest',
'honor','honored','honoring','honour','honoured','honouring','hope','hopeful','hopefully','hopes',
'hoping','hug','hugs','humor','humorous','humour','humourous','immortal','importance','important',
'improve','improved','improvement','improves','improving','indestructible','infatuated','infatuation',
'influential','innovative','inquisitive','inspiration','inspirational','inspire','inspired','inspires',
'intact','integrity','intelligent','interested','interesting','intricate','invincible','invulnerable',
'irresistible','irresponsible','jaunty','jocular','joke','jokes','jolly','jovial','justice',
'justifiably','justified','kind','kinder','kiss','landmark','like','liked','likes','lively','loving',
'mature','meaningful','mercy','methodical','motivated','motivating','nifty','noble','novel','obsessed',
'oks','opportunities','opportunity','optimism','optimistic','outreach','pardon','pardoned','pardoning',
'pardons','passionate','peace','peaceful','peacefully','perfected','perfects','picturesque','playful',
'positive','positively','powerful','privileged','proactive','progress','prominent','proud','proudly',
'rapture','raptured','raptures','ratified','reassuring','recommend','recommended','recommends',
'redeemed','relaxed','reliant','relieved','relieving','relishing','remarkable','rescue','rescued',
'rescues','resolute','resolve','resolved','resolves','resolving','respected','responsible',
'responsive','restful','revered','revive','revives','reward','rewarded','rewarding','rewards',
'rich','robust','romance','satisfied','save','saved','secure','secured','secures','self-confident',
'serene','sincere','sincerely','sincerest','sincerity','slick','slicker','slickest','smarter',
'smartest','smile','smiled','smiles','smiling','solid','solidarity','sophisticated','spirited',
'sprightly','stable','stamina','steadfast','stimulating','stout','strength','strengthen',
'strengthened','strengthening','strengthens','strong','stronger','strongest','suave','success',
'sunshine','superior','support','supported','supportive','supports','survived','surviving','survivor',
'sweet','swift','swiftly','sympathetic','sympathy','tender','thank','thankful','thanks','thoughtful',
'tolerant','top','tops','tranquil','treasure','treasures','true','trusted','unbiased','unequaled',
'unstoppable','untarnished','useful','usefulness','vindicate','vindicated','vindicates','vindicating',
'virtuous','warmth','wealthy','welcome','welcomed','welcomes','willingness','worth','worthy','yeees',
'youthful'];

var pos1 = ['aboard','absorbed','accept','accepted','accepting','accepts','achievable','active',
'adequate','adopt','adopts','advanced','agree','agreed','agreement','agrees','alive','allow',
'anticipation','ardent','attract','attracted','attracts','authority','backed','backs','big','boost',
'boosted','boosting','boosts','bright','brightness','capable','carefree','certain','clear','cleared',
'clearly','clears','comedy','commit','commits','committed','committing','compelled','convince',
'convinced','convinces','cool','curious','decisive','desire','diamond','dream','dreams','easy',
'embrace','engage','engages','engrossed','ensure','ensuring','enterprising','entitled','expand',
'expands','exploration','explorations','extend','extends','faith','fame','feeling','fit','fitness',
'forgive','forgiving','free','fresh','god','grace','grant','granted','granting','grants','greet',
'greeted','greeting','greets','growing','guarantee','haunting','huge','immune','increase','increased',
'innovate','innovates','innovation','intense','interest','interests','intrigues','invite','inviting',
'jesus','jewel','jewels','join','keen','laugh','laughed','laughing','laughs','laughting','launched',
'legal','legally','lenient','lighthearted','matter','matters','meditative','motivate','motivation',
'natural','please','pray','praying','prays','prepared','pretty','promise','promised','promises',
'promote','promoted','promotes','promoting','prospect','prospects','protect','protected','protects',
'reach','reached','reaches','reaching','reassure','reassured','reassures','relieve','relieves',
'restore','restored','restores','restoring','safe','safely','safety','salient','share','shared',
'shares','significance','significant','smart','sobering','solution','solutions','solve','solved',
'solves','solving','spark','spirit','stimulate','stimulated','stimulates','straight','substantial',
'substantially','supporter','supporters','supporting','trust','unified','united','unmatched',
'validate','validated','validates','validating','vested','vision','visioning','visions','vitamin',
'want','warm','whimsical','wish','wishes','wishing','yeah','yearning','yes'];


exports.pos5 = pos5;
exports.pos4 = pos4;
exports.pos3 = pos3;
exports.pos2 = pos2;
exports.pos1 = pos1;