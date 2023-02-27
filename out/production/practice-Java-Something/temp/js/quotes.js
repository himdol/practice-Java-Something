const quotes = [
  {
    quote:"이기지 않아도 되니까 걱정하지 마라. 이기는 건 나중 문제다.",
    author: "유재석",
  },
  {
    quote:"어렸을 때는 넘어지는 게 겁이 안 나서 그래요... 어른이 될수록 넘어지는 것에 두려움이 있잖아요.",
    author: "유재석",
  },
  {
    quote:"멈추지 말고 쓰러지지 말고 앞만 보고 달려 너의 길을 가",
    author: "유재석",
  }, {
    quote:"나이가 들어간다는 건 내가 좋아하는 걸 하나씩 포기하는 것이다",
    author: "유재석",
  },
  {
    quote:"열 가지 중 한 가지는 안 좋을 수 있다. 아홉 가지 좋은 걸 생각하면서 행복하게 살면 된다",
    author: "유재석",
  },
  {
    quote:"지금의 노력이 없어질 것 같지만, 그렇지 않아요 몸이 기억할 거예요",
    author: "유재석",
  },
  {
    quote:"하루아침에 안 되더라도 하다 보면 된다",
    author: "유재석",
  },
  {
    quote:"일도 열심히 하면서 여자친구 만났을 때 여자친구한테 잘해 줘. 그럼 돼. 네가 일을 핑계로 여자친구한테 잘 못하니까 그렇지. 잘해줘라.",
    author: "유재석",
  },
  {
    quote:"괜찮으니까 포기만 하지마. 같이 가자",
    author: "유재석",
  },

]

const quote = document.querySelector("#quote span:first-child");
const author = document.querySelector("#quote span:last-child");

const todayQuote = quotes[Math.floor(Math.random() * quotes.length)];

quote.innerText = todayQuote.quote;
author.innerText = todayQuote.author;