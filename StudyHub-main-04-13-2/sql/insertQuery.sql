use [StudyHub]

insert into Admin(name, email, passwort) values ('Alexandra Mysyk','alexandra100854@gmail.com', '12345' )
insert into Admin (name, email, passwort) values ('Alina Biletska','rinwuy@gmail.com', '12345' )
insert into Admin (name, email, passwort) values ('Sofia Prykhodchenko','prisofff@gmail.com', '12345' )
--------------------------------------------
insert into [dbo].[User] ([name],	[email],[passwort]) values('Julia Chornenko','yuliachornenko@gmail.com','yulchor123')
insert into [dbo].[User] ([name],	[email],[passwort]) values('Ganna Bondarenko','gannabondarenko@gmail.com','gb107804')
insert into [dbo].[User] ([name],	[email],[passwort]) values('Volodymyr Honchar','volhonchar@gmail.com','658vh875')
insert into [dbo].[User] ([name],	[email],[passwort]) values('Kateryna Synelnyk','katsyn@gmail.com','katty0607')
insert into [dbo].[User] ([name],	[email],[passwort]) values('Yana Koshkina','yancat@gmail.com','thecat111')
--------------------------------------------
insert into [dbo].[Word]([name],[meaning],[translation]) values('delicious', 'very tasty','���� �������')
insert into [dbo].[Word]([name],[meaning],[translation]) values('insane','a crazy person','����������, �������, ������������')
insert into [dbo].[Word]([name],[meaning],[translation]) values('furious','an angry person','�����������, ����������, �����')
--------------------------------------------
insert into [dbo].[KindOfTask]([name]) values ('Flash-cards')
insert into [dbo].[KindOfTask]([name]) values ('Insert a word')
--------------------------------------------
insert into [dbo].[Text]([name],[content],[complexity_level],[fk_admin]) values('Many studies','Many studies about language learning ask the question: What makes a good language learner? There are some things that good language learners do and some things they don`t do. Here are some of the most useful suggestions from studies.
Don`t be afraid of making mistakes. People often get things wrong. Good language learners notice their mistakes and learn from them.
Do group activities. People use language to communicate with other people. A good language learner always looks for opportunities to talk with other students.
Make notes during every class. Notes help you to remember new language. Look at your notes when you do your homework.
Use a dictionary. Good language learners often use dictionaries to check the meaning of words they don`t know. They also make their own vocabulary lists.
Think in the language you`re learning outside the classroom. When you`re shopping or walking down the street, remember useful words and phrases. Sometimes, when you`re at home, say new words to practise your pronunciation.
Do extra practice. Test and improve your language, reading and listening skills with self-study material. You can find a lot of this online.
Imagine yourself speaking in the language. Many good language learners can see and hear themselves speaking in the language. This helps their motivation.
Enjoy the process. Good language learners have fun with the language. Watch a TV series or film, listen to songs, play video games or read a book. It`s never too late to become a good language learner.','A2',1)

insert into [dbo].[Text]([name],[content],[complexity_level],[fk_admin]) values('Sam squinted against','Sam squinted against the sun at the distant dust trail raked up by the car on its way up to the Big House. The horses kicked and flicked their tails at flies, not caring about their owner`s first visit in ten months. Sam waited. Mr Carter didn`t come out here unless he had to, which was just fine by Sam. The more he kept out of his boss`s way, the longer he`d have a job.
Carter came by later while Sam was chopping wood. Carter lifted his hat as if he were waiting for an appointment with the town priest, and then removed it completely as if he were talking to his mother. He pulled out a pile of paper from his back pocket and held it out.
"Don`t pick up your mail often, do you?"
Sam took it without a glance and dropped the envelopes onto the bench.
"Never," he replied and waited for Carter to say why he was here. The fact it was Carter`s house was no explanation and they both knew it. Carter twisted his hat round and round, licking his lips and clearing his throat.
"Nice work fixing those fences," he said finally.
"I`ll be back to the beginning soon," Sam said. It wasn`t a complaint. A fence that took a year to repair meant another year`s work to the man who did it well.
"Don`t you ever want to take a holiday?"
"And go where?" A holiday meant being back out in the real world, a place even people like Carter travelled to escape from. Sam`s escape was his reality and he wasn`t going back.
Mr Carter wiped the sweat from the back of his neck. The damp patches on his shirt drew together like shapes in an atlas. His skin was already turning ruddy in the June sun. Otherwise he had the indoor tan of a man that made money while other people did the work.
"I`ve brought my son with me on this trip. He`s had some trouble at school." Mr Carter`s eyes flicked up, blinked rapidly and then shifted back to the hat occupying his hands. "Not much trouble out here for a young boy." He attempted a laugh but it came out like a dog`s bark.
The two men looked towards the northern end of the property. It stretched as far as the eye could see. Even the fences were barely visible from where they stood. However bored and rebellious a teenage boy might get, it wasn`t possible to escape on foot. Sam looked at the biggest of the horses, kicking at the ground with its heavy hooves. Could the boy ride? he wondered. There was a whole load of trouble a good rider could get into out here, miles away from anyone. But maybe there was even more trouble for someone who knew nothing about horses and wanted to get away from his father.','B2',1)
--------------------------------------------
insert into [dbo].[PersonalDictionary]([fk_word],[fk_user]) values (1,1)
insert into [dbo].[PersonalDictionary]([fk_word],[fk_user]) values (1,2)
insert into [dbo].[PersonalDictionary]([fk_word],[fk_user]) values (1,3)
insert into [dbo].[PersonalDictionary]([fk_word],[fk_user]) values (1,4)
insert into [dbo].[PersonalDictionary]([fk_word],[fk_user]) values (1,5)
insert into [dbo].[PersonalDictionary]([fk_word],[fk_user]) values (2,1)
insert into [dbo].[PersonalDictionary]([fk_word],[fk_user]) values (2,2)
insert into [dbo].[PersonalDictionary]([fk_word],[fk_user]) values (2,3)
insert into [dbo].[PersonalDictionary]([fk_word],[fk_user]) values (2,4)
insert into [dbo].[PersonalDictionary]([fk_word],[fk_user]) values (2,5)

--------------------------------------------
insert into [dbo].[Texts]([fk_text],[fk_user]) values (1,1)
insert into [dbo].[Texts]([fk_text],[fk_user]) values (1,2)
insert into [dbo].[Texts]([fk_text],[fk_user]) values (1,3)
insert into [dbo].[Texts]([fk_text],[fk_user]) values (1,4)
insert into [dbo].[Texts]([fk_text],[fk_user]) values (1,5)
insert into [dbo].[Texts]([fk_text],[fk_user]) values (2,1)
insert into [dbo].[Texts]([fk_text],[fk_user]) values (2,2)
insert into [dbo].[Texts]([fk_text],[fk_user]) values (2,3)
insert into [dbo].[Texts]([fk_text],[fk_user]) values (2,4)
insert into [dbo].[Texts]([fk_text],[fk_user]) values (2,5)
--------------------------------------------

select *
from text
