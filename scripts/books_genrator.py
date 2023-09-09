import random


virtual_writers = {
    "Alexandra Algorithm": "Alexandra Algorithm is a virtual author known for her groundbreaking books on computational thinking and algorithms. Her works have become staples in computer science education.",
    "Daniel Datastream": "Daniel Datastream is a virtual novelist who seamlessly blends science fiction with real-world technological concepts. His books transport readers to futuristic worlds filled with advanced AI.",
    "Sophie Syntax": "Sophie Syntax is a virtual writer acclaimed for her engaging guides on programming languages. Her books have empowered countless learners to master coding.",
    "Nathan Network": "Nathan Network is a virtual author specializing in cybersecurity thrillers. His novels keep readers on the edge of their seats while offering valuable insights into digital security.",
    "Emma Encryption": "Emma Encryption is a virtual writer known for her series of cryptographic mysteries. Her books challenge readers to solve intricate puzzles while learning about encryption techniques.",
    "Oliver Omniverse": "Oliver Omniverse is a virtual science fiction writer who crafts imaginative tales set in parallel digital universes. His narratives explore the limitless possibilities of virtual reality.",
    "Grace Code": "Grace Code is a virtual author celebrated for her eloquent explanations of complex coding concepts. Her books serve as invaluable resources for programmers of all levels.",
    "Lucas Logarithm": "Lucas Logarithm is a virtual mathematician and author, renowned for his comprehensive textbooks on advanced mathematical topics. His clarity of expression makes even the most challenging subjects accessible.",
    "Lily Logic": "Lily Logic is a virtual logician who pens philosophical works on the nature of artificial intelligence and human cognition. Her books delve into the intersections of logic, ethics, and technology.",
    "Ethan Echo": "Ethan Echo is a virtual journalist who has turned his investigative skills to write exposés on emerging technologies. His books provide critical insights into the digital landscape.",
    "Ava Avatar": "Ava Avatar is a virtual author specializing in speculative fiction that explores the ethical implications of AI and virtual existence. Her thought-provoking narratives challenge conventional perspectives.",
    "Zara Zero-Day": "Zara Zero-Day is a virtual thriller writer whose gripping plots revolve around cyber warfare and espionage. Her books offer a thrilling glimpse into the shadowy world of digital intrigue.",
    "Mia Metadata": "Mia Metadata is a virtual expert in data science, known for her informative guides on data analysis and machine learning. Her books empower readers to harness the power of data.",
    "Oscar Octave": "Oscar Octave is a virtual composer and writer who creates books that explore the intersection of music and technology. His works highlight the transformative potential of digital sound.",
    "Henry Hologram": "Henry Hologram is a virtual futurist and author, envisioning the possibilities of technology in shaping society. His books offer imaginative and thought-provoking glimpses into the future.",
    "Isabella Interface": "Isabella Interface is a virtual author specializing in user experience design and human-computer interaction. Her books provide valuable insights for designers striving to create intuitive interfaces.",
    "Nina Nanobot": "Nina Nanobot is a virtual scientist and author focusing on nanotechnology and its potential applications. Her books illuminate the incredible possibilities at the nanoscale.",
    "Sophia Simulation": "Sophia Simulation is a virtual philosopher and author, delving into questions of reality, consciousness, and the nature of existence in digital environments. Her books challenge our understanding of the virtual world.",
    "Noah Neural": "Noah Neural is a virtual neuroscientist and author, exploring the intricacies of artificial neural networks. His books offer a comprehensive understanding of the brain-inspired algorithms.",
    "Liam Lambda": "Liam Lambda is a virtual author known for his comprehensive guides on functional programming languages. His books are essential resources for developers seeking to master this paradigm.",
    "Aiden Avatar": "Aiden Avatar is a virtual storyteller, crafting immersive narratives that explore the convergence of human emotion and AI intelligence. His books blur the lines between the virtual and the real.",
    "Ella Encryption": "Ella Encryption is a virtual expert in cryptography, known for her detailed treatises on cryptographic protocols and secure communication. Her books are essential references for security professionals.",
    "Zachary Zero-G": "Zachary Zero-G is a virtual author specializing in space exploration and the future of space travel. His books take readers on thrilling journeys through the cosmos.",
    "Vera Virtual": "Vera Virtual is a virtual author and visionary, speculating on the potential impact of virtual reality on society and human experiences. Her books inspire contemplation of a digitally augmented future.",
    "Xander Xenon": "Xander Xenon is a virtual physicist and author, delving into the realms of quantum mechanics and the peculiarities of the quantum world. His books illuminate the mysteries of the subatomic.",
    "Lara Luminary": "Lara Luminary is a virtual astronomer and author, translating the wonders of the universe into captivating prose. Her books ignite a sense of wonder for the cosmos.",
    "Aria Algorithm": "Aria Algorithm is a virtual author renowned for her contributions to algorithm design and optimization. Her books are revered as authoritative resources in the field.",
    "Leo Lexicon": "Leo Lexicon is a virtual linguist and author, examining the evolution of language in the digital age. His books explore the intricate relationship between language and technology.",
    "Milo Megabyte": "Milo Megabyte is a virtual author known for his humorous take on the quirks and idiosyncrasies of the digital world. His books provide a lighthearted perspective on technology.",
    "Quincy Quantum": "Quincy Quantum is a virtual physicist and author, unraveling the complexities of quantum computing and its potential impact on computation. His books are essential reading for those exploring this cutting-edge field."
}

birth_dates = {
    "Alexandra Algorithm": "1990-01-05",
    "Daniel Datastream": "1985-03-12",
    "Sophie Syntax": "1992-06-20",
    "Nathan Network": "1982-08-08",
    "Emma Encryption": "1991-04-18",
    "Oliver Omniverse": "1978-11-25",
    "Grace Code": "1989-02-14",
    "Lucas Logarithm": "1975-07-30",
    "Lily Logic": "1987-10-03",
    "Ethan Echo": "1984-05-07",
    "Ava Avatar": "1993-09-15",
    "Zara Zero-Day": "1980-12-10",
    "Mia Metadata": "1996-03-28",
    "Oscar Octave": "1983-06-08",
    "Henry Hologram": "1970-04-05",
    "Isabella Interface": "1988-08-22",
    "Nina Nanobot": "1994-01-17",
    "Sophia Simulation": "1981-10-09",
    "Noah Neural": "1990-02-11",
    "Liam Lambda": "1986-05-25",
    "Aiden Avatar": "1992-07-02",
    "Ella Encryption": "1983-11-14",
    "Zachary Zero-G": "1977-09-07",
    "Vera Virtual": "1989-12-19",
    "Xander Xenon": "1973-03-31",
    "Lara Luminary": "1984-04-23",
    "Aria Algorithm": "1982-06-15",
    "Leo Lexicon": "1991-07-12",
    "Milo Megabyte": "1979-08-27",
    "Quincy Quantum": "1976-10-20"
}

def get_sql_authors_command(author_name, id):
    first_name = author_name.split(" ")[0]
    last_name = author_name.split(" ")[1]
    dob = birth_dates[author_name]
    bio = virtual_writers[author_name]
    sql_stm = f"""INSERT INTO `readjourney`.`authors` (`id`, `biography`, `birth_date`, `first_name`, `last_name`) VALUES ('{id}', '{bio}', '{dob}', '{first_name}', '{last_name}');"""
    return sql_stm

# with open("authors_insertion.sql", "a") as f:
#     id = 1
#     for author_name in virtual_writers.keys():
#         f.write(get_sql_authors_command(author_name, id))
#         id += 1
#     print("done")











publishers = ["Harriman House", "JP Medical Publishers", "University of Westminster Press",
              "Penguin Books Australia", "Manning Publications", "Emerald Group Publishing",
              "Apress", "CSIRO Publishing", "Science Publishers", "CRC Press",
              "Douglas & McIntyre", "Brush Education", "Boulder Books", "Allen & Unwin",
              "Sage Publishing", "Between The Lines", "Wiley", "Artech House", "Springer"
            ]

authors = ["Benjamin A. Mitchell", "Olivia R. Harrison", "Henry J. Thompson",
           "Isabella M. Anderson", "Samuel L. Parker", "Charlotte E. Collins",
           "William H. Turner", "Emily C. Nelson", "Alexander G. Foster",
           "Sophia B. Hayes","Daniel J. Murphy","Ava L. Bennett",
           "Ethan R. Foster", "Grace E. Mitchell", "Benjamin A. Harrison",
           "Lily M. Parker", "Samuel L. Carter", "Sophia E. Turner",
           "Oliver J. Anderson", "Mia C. Mitchell", "Jackson A. Hayes",
           "Sophia R. Thompson", "William J. Wilson", "Abigail M. Harris",
           "Michael L. Campbell", "Amelia R. Scott", "Noah S. Davis",
           "Ella M. Reed", "James A. Powell", "Sophia J. Anderson",
           "Benjamin L. Taylor", "Olivia R. Murphy", "Henry A. Parker",
           "Emily S. Wilson", "William J. Carter", "Ava R. Mitchell",
           "Samuel G. Turner", "Mia E. Johnson", "Alexander R. Collins",
           "Charlotte L. Bennett", "Noah E. Foster", "Grace A. Campbell",
           "Ethan J. Hayes", "Sophia L. Nelson", "Benjamin G. Reed",
           "Emily M. Mitchell", "Oliver J. Harris", "Ava L. Foster",
           "Samuel A. Wilson", "Isabella J. Turner"
        ]

languages = [
    "English",
    "Spanish",
    "French",
    "German",
    "Chinese",
    "Japanese",
    "Russian",
    "Italian",
    "Portuguese",
    "Arabic",
    "Hindi",
    "Korean",
    "Dutch",
    "Swedish",
    "Greek"
]

book_titles = [
    'Clean Code: A Handbook of Agile Software Craftsmanship',
    'Design Patterns: Elements of Reusable Object-Oriented Software',
    'Introduction to the Theory of Computation',
    'Cracking the Coding Interview: 189 Programming Questions and Solutions',
    'Code: The Hidden Language of Computer Hardware and Software',
    'The Pragmatic Programmer: Your Journey to Mastery',
    'Artificial Intelligence: A Modern Approach',
    'Effective Java',
    'Algorithms',
    'Operating System Concepts',
    'Introduction to Algorithms',
    "Clean Architecture: A Craftsman's Guide to Software Structure and Design",
    'Head First Design Patterns',
    'Database System Concepts',
    'Computer Networking: A Top-Down Approach',
    'Introduction to the Practice of Statistics',
    'Artificial Intelligence: Foundations of Computational Agents',
    'Introduction to Automata Theory, Languages, and Computation',
    'Computer Organization and Design: The Hardware/Software Interface',
    'Designing Data-Intensive Applications',
    'Introduction to Machine Learning',
    'Introduction to Information Retrieval',
    'Advanced Programming in the UNIX Environment',
    'Concrete Mathematics: A Foundation for Computer Science',
    'Automate the Boring Stuff with Python',
    'Artificial Intelligence for Humans: Fundamental Algorithms',
    'Fundamentals of Database Systems',
    'Introduction to Artificial Intelligence',
    "Software Engineering: A Practitioner's Approach",
    'Compilers: Principles, Techniques, and Tools',
    'Introduction to Data Mining',
    'Data Structures and Algorithms in Java',
    "Computer Systems: A Programmer's Perspective",
    'Foundations of Statistical Natural Language Processing',
    'Introduction to Artificial Intelligence',
    'Introduction to the Theory of Neural Computation',
    'Effective C++: 55 Specific Ways to Improve Your Programs and Designs',
    'Introduction to Probability',
    'Operating Systems: Three Easy Pieces',
    'Foundations of Machine Learning',
    'Introduction to Data Science',
    'Introduction to Artificial Intelligence',
    'Effective C++: 55 Specific Ways to Improve Your Programs and Designs',
    'Introduction to Probability',
    'Operating Systems: Three Easy Pieces',
    'Foundations of Machine Learning',
    'Introduction to Data Science',
    'Introduction to Artificial Intelligence',
    'Effective C++: 55 Specific Ways to Improve Your Programs and Designs',
    'Introduction to Probability'
]

page_nnmbers = [random.randint(100, 1500) for x in range(0, 50)]


chatgpt_response = """
Clean Code: A Handbook of Agile Software Craftsmanship*/*by Robert C. Martin
Design Patterns: Elements of Reusable Object-Oriented Software*/*by Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides, Grady Booch
Introduction to the Theory of Computation*/*by Michael Sipser
Cracking the Coding Interview: 189 Programming Questions and Solutions*/*by Gayle Laakmann McDowell
Code: The Hidden Language of Computer Hardware and Software*/*by Charles Petzold
The Pragmatic Programmer: Your Journey to Mastery*/*by Andrew Hunt, David Thomas
Artificial Intelligence: A Modern Approach*/*by Stuart Russell, Peter Norvig
Effective Java*/*by Joshua Bloch
Algorithms*/*by Robert Sedgewick, Kevin Wayne
Operating System Concepts*/*by Abraham Silberschatz, Peter B. Galvin, Greg Gagne
Introduction to Algorithms*/*by Thomas H. Cormen, Charles E. Leiserson, Ronald L. Rivest, Clifford Stein
Clean Architecture: A Craftsman's Guide to Software Structure and Design*/*by Robert C. Martin
Head First Design Patterns*/*by Eric Freeman, Elisabeth Robson, Bert Bates, Kathy Sierra
Database System Concepts*/*by Abraham Silberschatz, Henry F. Korth, S. Sudarshan
Computer Networking: A Top-Down Approach*/*by James Kurose, Keith Ross
Introduction to the Practice of Statistics*/*by David S. Moore, George P. McCabe, Bruce A. Craig
Artificial Intelligence: Foundations of Computational Agents*/*by David Poole, Alan Mackworth
Introduction to Automata Theory, Languages, and Computation*/*by John E. Hopcroft, Rajeev Motwani, Jeffrey D. Ullman
Computer Organization and Design: The Hardware/Software Interface*/*by David A. Patterson, John L. Hennessy
Designing Data-Intensive Applications*/*by Martin Kleppmann
Introduction to Machine Learning*/*by Ethem Alpaydin
Introduction to Information Retrieval*/*by Christopher D. Manning, Prabhakar Raghavan, Hinrich Schütze
Advanced Programming in the UNIX Environment*/*by W. Richard Stevens, Stephen A. Rago
Concrete Mathematics: A Foundation for Computer Science*/*by Ronald L. Graham, Donald E. Knuth, Oren Patashnik
Automate the Boring Stuff with Python*/*by Al Sweigart
Artificial Intelligence for Humans: Fundamental Algorithms*/*by Jeff Heaton
Fundamentals of Database Systems*/*by Ramez Elmasri, Shamkant B. Navathe
Introduction to Artificial Intelligence*/*by Wolfgang Ertel
Software Engineering: A Practitioner's Approach*/*by Roger S. Pressman
Compilers: Principles, Techniques, and Tools*/*by Alfred V. Aho, Monica S. Lam, Ravi Sethi, Jeffrey D. Ullman
Introduction to Data Mining*/*by Pang-Ning Tan, Michael Steinbach, Vipin Kumar
Data Structures and Algorithms in Java*/*by Robert Lafore
Computer Systems: A Programmer's Perspective*/*by Randal E. Bryant, David R. O'Hallaron
Foundations of Statistical Natural Language Processing*/*by Christopher D. Manning, Hinrich Schütze
Introduction to Artificial Intelligence*/*by Philip C. Jackson Jr.
Introduction to the Theory of Neural Computation*/*by John A. Hertz, Anders S. Krogh, Richard G. Palmer
Effective C++: 55 Specific Ways to Improve Your Programs and Designs*/*by Scott Meyers
Introduction to Probability*/*by Joseph K. Blitzstein, Jessica Hwang
Operating Systems: Three Easy Pieces*/*by Remzi H. Arpaci-Dusseau, Andrea C. Arpaci-Dusseau
Foundations of Machine Learning*/*by Mehryar Mohri, Afshin Rostamizadeh, Ameet Talwalkar
Introduction to Data Science*/*by Jeffrey Stanton
Introduction to Artificial Intelligence*/*by Philip C. Jackson Jr.
Effective C++: 55 Specific Ways to Improve Your Programs and Designs*/*by Scott Meyers
Introduction to Probability*/*by Joseph K. Blitzstein, Jessica Hwang
Operating Systems: Three Easy Pieces*/*by Remzi H. Arpaci-Dusseau, Andrea C. Arpaci-Dusseau
Foundations of Machine Learning*/*by Mehryar Mohri, Afshin Rostamizadeh, Ameet Talwalkar
Introduction to Data Science*/*by Jeffrey Stanton
Introduction to Artificial Intelligence*/*by Philip C. Jackson Jr.
Effective C++: 55 Specific Ways to Improve Your Programs and Designs*/*by Scott Meyers
Introduction to Probability*/*by Joseph K. Blitzstein, Jessica Hwang
"""

titles = []
description = []
splited_list = chatgpt_response.split('\n')

for book in splited_list:
    if book != "":
        splited_book = book.split("*/*")
        titles.append(splited_book[0])
        description.append(splited_book[1])





