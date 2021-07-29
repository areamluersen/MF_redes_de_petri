const places = [
    {id: 1, tokens: 0, valor: 1},
    {id: 2, tokens: 1, valor: 2},
    {id: 3, tokens: 1, valor: 3},
    {id: 4, tokens: 1, valor: 4},
]
console.log("🚀 --------------------------------------------")
console.log("🚀 ~ file: teste.js ~ line 6 ~ places", places)
console.log("🚀 --------------------------------------------")

const transitions = [
    {id: 1, valor: 1},
    {id: 2, valor: 2},
]
console.log("🚀 -------------------------------------------------------")
console.log("🚀 ~ file: teste.js ~ line 13 ~ transitions", transitions)
console.log("🚀 -------------------------------------------------------")

const pre = [
    [1,1,1],
    [2,1,1],
    [2,2,1],
    [3,2,1],
]
console.log("🚀 ---------------------------------------")
console.log("🚀 ~ file: teste.js ~ line 21 ~ pre", pre)
console.log("🚀 ---------------------------------------")

const pos = [
    [1,4,1],
    [2,4,1],
]
console.log("🚀 ---------------------------------------")
console.log("🚀 ~ file: teste.js ~ line 28 ~ pos", pos)
console.log("🚀 ---------------------------------------")


const EnabledTransitions = transitions.filter(f => {
    const preLinked = pre.filter(p => p[1] === f.id)
    console.log("🚀 ---------------------------------------------------")
    console.log("🚀 ~ file: teste.js ~ line 35 ~ preLinked", preLinked)
    console.log("🚀 ---------------------------------------------------")
    let allResources = true;
    preLinked.forEach(element => {
        const place = places.find(p => p.id === element[0]);
        if(!(place.tokens >= element[2])){
            allResources = false;
        }
    });
    return allResources;
})
console.log("🚀 ---------------------------------------------------------------------")
console.log("🚀 ~ file: teste.js ~ line 48 ~ EnabledTransitions", EnabledTransitions)
console.log("🚀 ---------------------------------------------------------------------")
