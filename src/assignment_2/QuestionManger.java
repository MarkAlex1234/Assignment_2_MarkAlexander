/*

Assignment 1 - Program Design & Construction 2022

Coded by Mark Alexander
ID: 20112145

 */
package assignment_2;

import java.util.Random;

public final class QuestionManger {

    public String aQuestion;
    public String answer;

    public QuestionManger() {
        this.getQuestion();
    }

    public void getQuestion() {
        this.aQuestion = this.generateRandomQuestion();
        this.getResult();
    }

    public int generateNumber() {
        Random generator = new Random();
        int i = generator.nextInt(16);
        return i;
    }

    public String generateRandomQuestion() {
        int i = generateNumber();
        String q;
        switch (i) {
            case 0:
                q = "Captial of New Zealand is?"
                        + "\nA: Wellington"
                        + "\nB: Dunedin"
                        + "\nC: Chirstchurch"
                        + "\nD: Auckland";
                break;
            case 1:
                q = "The hammer and sickle is one of the most recognisable symbols of which political ideology?"
                        + "\nA: Republicanism"
                        + "\nB: Communism"
                        + "\nC: Conservatism"
                        + "\nD: Liberalism";
                break;
            case 2:
                q = "Obstetrics is a branch of medicine particularly concerned with what?"
                        + "\nA: Childbirth"
                        + "\nB: Broken bones"
                        + "\nC: Heart conditions"
                        + "\nD: Old age";
                break;
            case 3:
                q = "Construction of which of these famous landmarks was completed first?"
                        + "\nA: Empire State Building"
                        + "\nB: Royal Albert Hall"
                        + "\nC: Eiffel Tower"
                        + "\nD: Big Ben Clock Tower";
                break;
            case 4:
                q = "What was the first Star Wars Movie released?"
                        + "\nA: A New Hope"
                        + "\nB: Revenge of the Sith"
                        + "\nC: Return of the Jedi"
                        + "\nD: The Force Awakens";
                break;
            case 5:
                q = "Who won the English Football Premier League in 2019?"
                        + "\nA: Chelsea"
                        + "\nB: Man City"
                        + "\nC: Liverpool"
                        + "\nD: Everton";
                break;
            case 6:
                q = "In 1718, which pirate died in battle off the coast of what is now North Carolina?"
                        + "\nA: Calico Jack"
                        + "\nB: Blackbeard"
                        + "\nC: Bartholomew Roberts"
                        + "\nD: Captain Kidd";
                break;
            case 7:
                q = "Which toys have been marketed with the phrase “robots in disguise?"
                        + "\nA: Bratz Dolls"
                        + "\nB: Toy Story"
                        + "\nC: Transformers"
                        + "\nD: Hot Wheels";
                break;
            case 8:
                q = "What name is given to the revolving belt machinery in an airport that delivers checked luggage from the plane to baggage reclaim?"
                        + "\nA: Hangar"
                        + "\nB: Terminal"
                        + "\nC: Concourse"
                        + "\nD: Carousel";
                break;
            case 9:
                q = "Which Disney character famously leaves a glass slipper behind at a royal ball?"
                        + "\nA: Pocahontas"
                        + "\nB: Sleeping Beauty"
                        + "\nC: Cinderella"
                        + "\nD: Elsa";
                break;
            case 10:
                q = "Who coded this Assignment?"
                        + "\nA: Mark Alexander"
                        + "\nB: John Doe"
                        + "\nC: Micheal Jones"
                        + "\nD: Fred";
                break;
            case 11:
                q = "How old must you be to enter Bar101 in NZ?"
                        + "\nA: 21"
                        + "\nB: 18"
                        + "\nC: 16"
                        + "\nD: 12";
                break;
            case 12:
                q = "What is the name of Darth Vaders' Son?"
                        + "\nA: Jake Skywalker"
                        + "\nB: Anakin Skywalker"
                        + "\nC: Luke Skywalker"
                        + "\nD: Leia Skywalker";
                break;
            case 13:
                q = "In the UK, the abbreviation NHS stands for National what Service?"
                        + "\nA: Humanity"
                        + "\nB: Health"
                        + "\nC: Honour"
                        + "\nD: Household";
                break;
            case 14:
                q = "Who is Spiderman?"
                        + "\nA: Bruce Waynce"
                        + "\nB: John Doe"
                        + "\nC: Peter Parker"
                        + "\nD: Jack";
                break;
            case 15:
                q = "What does the word loquacious mean?"
                        + "\nA: Angry"
                        + "\nB: Chatty"
                        + "\nC: Beautiful"
                        + "\nD: Shy";
                break;

            default:
                q = "--> ERROR QUESTION OUT OF CASE RANGE";
        }
        return q;
    }

    // @Override
    private void getResult() {

        switch (aQuestion) {
            case "Captial of New Zealand is?"
            + "\nA: Wellington"
            + "\nB: Dunedin"
            + "\nC: Chirstchurch"
            + "\nD: Auckland":

                this.answer = AnswerEnum.A.toString();
                break;
            case "The hammer and sickle is one of the most recognisable symbols of which political ideology?"
            + "\nA: Republicanism"
            + "\nB: Communism"
            + "\nC: Conservatism"
            + "\nD: Liberalism":
                this.answer = AnswerEnum.B.toString();
                break;
            case "Obstetrics is a branch of medicine particularly concerned with what?"
            + "\nA: Childbirth"
            + "\nB: Broken bones"
            + "\nC: Heart conditions"
            + "\nD: Old age":
                this.answer = AnswerEnum.A.toString();
                break;
            case "Construction of which of these famous landmarks was completed first?"
            + "\nA: Empire State Building"
            + "\nB: Royal Albert Hall"
            + "\nC: Eiffel Tower"
            + "\nD: Big Ben Clock Tower":
                this.answer = AnswerEnum.D.toString();
                break;
            case "What was the first Star Wars Movie released?"
            + "\nA: A New Hope"
            + "\nB: Revenge of the Sith"
            + "\nC: Return of the Jedi"
            + "\nD: The Force Awakens":
                this.answer = AnswerEnum.A.toString();
                break;
            case "Who won the English Football Premier League in 2019?"
            + "\nA: Chelsea"
            + "\nB: Man City"
            + "\nC: Liverpool"
            + "\nD: Everton":
                this.answer = AnswerEnum.C.toString();
                break;
            case "In 1718, which pirate died in battle off the coast of what is now North Carolina?"
            + "\nA: Calico Jack"
            + "\nB: Blackbeard"
            + "\nC: Bartholomew Roberts"
            + "\nD: Captain Kidd":
                this.answer = AnswerEnum.B.toString();
                break;
            case "Which toys have been marketed with the phrase “robots in disguise?"
            + "\nA: Bratz Dolls"
            + "\nB: Toy Story"
            + "\nC: Transformers"
            + "\nD: Hot Wheels":
                this.answer = AnswerEnum.C.toString();
                break;
            case "What name is given to the revolving belt machinery in an airport that delivers checked luggage from the plane to baggage reclaim?"
            + "\nA: Hangar"
            + "\nB: Terminal"
            + "\nC: Concourse"
            + "\nD: Carousel":
                this.answer = AnswerEnum.D.toString();
                break;
            case "Which Disney character famously leaves a glass slipper behind at a royal ball?"
            + "\nA: Pocahontas"
            + "\nB: Sleeping Beauty"
            + "\nC: Cinderella"
            + "\nD: Elsa":
                this.answer = AnswerEnum.C.toString();
                break;
            case "Who coded this Assignment?"
            + "\nA: Mark Alexander"
            + "\nB: John Doe"
            + "\nC: Micheal Jones"
            + "\nD: Fred":
                this.answer = AnswerEnum.A.toString();
                break;
            case "What is the name of Darth Vaders' Son?"
            + "\nA: Jake Skywalker"
            + "\nB: Anakin Skywalker"
            + "\nC: Luke Skywalker"
            + "\nD: Leia Skywalker":
                this.answer = AnswerEnum.C.toString();
                break;
            case "How old must you be to enter Bar101 in NZ?"
            + "\nA: 21"
            + "\nB: 18"
            + "\nC: 16"
            + "\nD: 12":
                this.answer = AnswerEnum.B.toString();
                break;
            case "In the UK, the abbreviation NHS stands for National what Service?"
            + "\nA: Humanity"
            + "\nB: Health"
            + "\nC: Honour"
            + "\nD: Household":
                this.answer = AnswerEnum.B.toString();
                break;

            case "Who is Spiderman?"
            + "\nA: Bruce Waynce"
            + "\nB: John Doe"
            + "\nC: Peter Parker"
            + "\nD: Jack":
                this.answer = AnswerEnum.C.toString();
                break;
            case "What does the word loquacious mean?"
            + "\nA: Angry"
            + "\nB: Chatty"
            + "\nC: Beautiful"
            + "\nD: Shy":
                this.answer = AnswerEnum.B.toString();
                break;

        }
    }
}
